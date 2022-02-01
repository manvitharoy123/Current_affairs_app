package data.example.edunachal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.edunachal.R;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ServerValue;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class UploadPdf extends AppCompatActivity {
    String flagExtra, flagExtra1;
    EditText editText;
    ProgressBar progressBar;
    Uri uri;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_pdf);
        editText=findViewById(R.id.editTextTextPersonName7);
        progressBar=findViewById(R.id.progressBar10);
        button=findViewById(R.id.button18);
        flagExtra=getIntent().getStringExtra("flagExtra");
        flagExtra1 = getIntent().getStringExtra("flagExtra1");
    }

    public void SelectFile(View view) {
        progressBar.setVisibility(View.VISIBLE);
        Intent intent = new Intent();
        intent.setType("application/pdf");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select PDF"),1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK)
        {
            if(requestCode==1)
            {
                uri = data.getData();
                String result = uri.getPath();
                int cut=result.lastIndexOf("/");
                button.setText(result.substring(cut+1));
            }
        }
        progressBar.setVisibility(View.INVISIBLE);
    }

    public void UploadIt(View view) {
        String name = editText.getText().toString().trim();
        if(uri==null)
        {
            Toast.makeText(this, "Choose a file", Toast.LENGTH_SHORT).show();
        }
        else if(name.isEmpty())
        {
            editText.setError("Required a valid Title");
        }
        else if(name.contains(".")||name.contains("#")||name.contains("$")||name.contains("[")||name.contains("]"))
        {
            editText.setError("Name  must not contain '.', '#', '$', '[', or ']'");
        }
        else
        {
            progressBar.setVisibility(View.VISIBLE);
            DateFormat df = new SimpleDateFormat("yyyyMMddhhmmssS");
            String filename = name+df.format(new Date()) + ".pdf";
            progressBar.setIndeterminate(false);
            progressBar.setMax(100);
            StorageReference storageReference = FirebaseStorage.getInstance().getReference().child(flagExtra).child(flagExtra1).child(filename);
            UploadTask uploadTask = storageReference.putFile(uri);
            uploadTask.addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onProgress(@NonNull UploadTask.TaskSnapshot snapshot) {
                    double progress = ((100.0 * snapshot.getBytesTransferred())/snapshot.getTotalByteCount());
                    progressBar.setProgress((int)progress);
                }
            });
            Task<Uri> urlTask = uploadTask.continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
                @Override
                public Task<Uri> then(@NonNull Task<UploadTask.TaskSnapshot> task) throws Exception {
                    if(!task.isSuccessful())
                    {
                        throw task.getException();
                    }
                    return storageReference.getDownloadUrl();
                }
            }).addOnCompleteListener(new OnCompleteListener<Uri>() {
                @Override
                public void onComplete(@NonNull Task<Uri> task) {
                    if(task.isSuccessful())
                    {
                        progressBar.setIndeterminate(true);
                        Uri downloadUri = task.getResult();
                        Map map = new HashMap();
                        map.put("name",name);
                        map.put("url",downloadUri.toString());
                        map.put("timestamp", ServerValue.TIMESTAMP);

                        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child(flagExtra).child(flagExtra1).child(filename.replace(".pdf",""));
                        databaseReference.updateChildren(map, new DatabaseReference.CompletionListener() {
                            @Override
                            public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {
                                if(error!=null)
                                {
                                    Toast.makeText(UploadPdf.this, "Some error: "+error.getMessage(), Toast.LENGTH_SHORT).show();
                                }
                                else
                                {
                                    Toast.makeText(UploadPdf.this, "Uploaded", Toast.LENGTH_SHORT).show();
                                    editText.setText("");
                                }
                                progressBar.setVisibility(View.INVISIBLE);
                            }
                        });
                    }
                    else
                    {
                        progressBar.setVisibility(View.INVISIBLE);
                        Toast.makeText(UploadPdf.this, "Error "+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}