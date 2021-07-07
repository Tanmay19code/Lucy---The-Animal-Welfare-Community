package com.tanmay.lucy;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.util.Objects;

public class HomeDashActivity extends AppCompatActivity {

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finishAffinity();
    }

    FirebaseAuth firebaseAuth;
    FirebaseFirestore firebaseFirestore;
    private ImageView profilePic;
    public Uri imageUri;
    private FirebaseStorage storage;
    private StorageReference storageReference,mstorageReference;
//    String emailStr,nameStr;
    ImageView profile;
    ImageView logoutIMG,adoptionIMG,animalActIMG,helpIMG,emergencyIMG;
    TextView username,usermail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_dash);

        getSupportActionBar().hide();
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();
        profilePic = findViewById(R.id.profilePicture);

        storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference();

        username = (TextView)findViewById(R.id.usernameTxtView);
        usermail = (TextView)findViewById(R.id.UserMailTxtView);

        String userId = firebaseAuth.getCurrentUser().getEmail();


        DocumentReference docReference = firebaseFirestore.collection("UserInfo")
                .document(userId);
        docReference.get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        if (documentSnapshot.exists()){
                           String emailStr =  documentSnapshot.getString("email");
                            String nameStr = documentSnapshot.getString("name");

                            username.setText(nameStr);
                            usermail.setText(emailStr);

                        }
                        else{
                            Toast.makeText(HomeDashActivity.this, "Document does not exist.", Toast.LENGTH_SHORT).show();
                        }
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull @NotNull Exception e) {
                        Toast.makeText(HomeDashActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                    }
                });


        profilePic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callAnimation();
                choosePicture();
            }
        });

        profile = (ImageView)findViewById(R.id.profilePicture);
        final String user = Objects.requireNonNull(firebaseAuth.getCurrentUser()).getEmail();

        mstorageReference = FirebaseStorage.getInstance().getReference().child("ProfilePictures/" + user);
        try{
            final File localFile = File.createTempFile("userProfile","png");
            mstorageReference.getFile(localFile)
                    .addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                            Bitmap bitmap = BitmapFactory.decodeFile(localFile.getAbsolutePath());
                            profile.setImageBitmap(bitmap);
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull @NotNull Exception e) {
                            Toast.makeText(HomeDashActivity.this, "Failed to find profile", Toast.LENGTH_SHORT).show();
                        }
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }

        logoutIMG = (ImageView)findViewById(R.id.logoutBTN);
        logoutIMG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Animation myAnim = AnimationUtils.loadAnimation(HomeDashActivity.this, R.anim.bounce);
                logoutIMG.startAnimation(myAnim);

                firebaseAuth.signOut();
                Intent intentSetting = new Intent(HomeDashActivity.this,MainActivity.class);
                startActivity(intentSetting);
            }
        });
        logoutIMG.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                final Animation myAnim = AnimationUtils.loadAnimation(HomeDashActivity.this, R.anim.bounce);
                logoutIMG.startAnimation(myAnim);

                return false;
            }
        });

        adoptionIMG = (ImageView)findViewById(R.id.adoptionBTN);
        adoptionIMG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Animation myAnim = AnimationUtils.loadAnimation(HomeDashActivity.this, R.anim.bounce);
                adoptionIMG.startAnimation(myAnim);

                startActivity(new Intent(HomeDashActivity.this,AdoptionActivity.class));
            }
        });
        adoptionIMG.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                final Animation myAnim = AnimationUtils.loadAnimation(HomeDashActivity.this, R.anim.bounce);
                adoptionIMG.startAnimation(myAnim);

                return false;
            }
        });

        animalActIMG = (ImageView)findViewById(R.id.animalActBTN);
        animalActIMG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Animation myAnim = AnimationUtils.loadAnimation(HomeDashActivity.this, R.anim.bounce);
                animalActIMG.startAnimation(myAnim);

                startActivity(new Intent(HomeDashActivity.this,AnimalActActivity.class));
            }
        });
        animalActIMG.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                final Animation myAnim = AnimationUtils.loadAnimation(HomeDashActivity.this, R.anim.bounce);
                animalActIMG.startAnimation(myAnim);

                return false;
            }
        });

        helpIMG = (ImageView)findViewById(R.id.helpBTN);
        helpIMG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Animation myAnim = AnimationUtils.loadAnimation(HomeDashActivity.this, R.anim.bounce);
                helpIMG.startAnimation(myAnim);
                startActivity(new Intent(HomeDashActivity.this,HelpActivity.class));
            }
        });
        helpIMG.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                final Animation myAnim = AnimationUtils.loadAnimation(HomeDashActivity.this, R.anim.bounce);
                helpIMG.startAnimation(myAnim);
                return false;
            }
        });

        emergencyIMG = (ImageView)findViewById(R.id.assistanceBTN);
        emergencyIMG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Animation myAnim = AnimationUtils.loadAnimation(HomeDashActivity.this, R.anim.bounce);
                emergencyIMG.startAnimation(myAnim);
                startActivity(new Intent(HomeDashActivity.this,EmergencyActivity.class));
            }
        });
        emergencyIMG.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                final Animation myAnim = AnimationUtils.loadAnimation(HomeDashActivity.this, R.anim.bounce);
                emergencyIMG.startAnimation(myAnim);

                return false;
            }
        });

    }

    public void choosePicture() {
        Intent intent = new Intent();
        intent.setType("image/");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent,1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable @org.jetbrains.annotations.Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK && data != null && data.getData() != null) {
            imageUri = data.getData();
            profilePic.setImageURI(imageUri);

            uploadPicture();
        }
    }

    private void uploadPicture() {
        final ProgressDialog pd = new ProgressDialog(this);
        pd.setTitle("Uploading Image....");
        pd.show();

//        final String randomKey = UUID.randomUUID().toString();
        final String user = Objects.requireNonNull(firebaseAuth.getCurrentUser()).getEmail();

        StorageReference riversReference = storageReference.child("ProfilePictures/" + user);
        riversReference.putFile(imageUri)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        pd.dismiss();
                        Snackbar.make(findViewById(android.R.id.content), "Image Uploaded", Snackbar.LENGTH_LONG).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull @NotNull Exception e) {
                pd.dismiss();
                Toast.makeText(getApplicationContext(),"Failed to Upload...",Toast.LENGTH_LONG).show();
            }
        }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onProgress(@NonNull @NotNull UploadTask.TaskSnapshot tasksnapshot) {
                double progressPercentage = (100.00 * tasksnapshot.getBytesTransferred() / tasksnapshot.getTotalByteCount());
                pd.setMessage("Progress: " + (int)progressPercentage + "%");
            }
        });

    }

    public void callAnimation(){
//        Button signupBTN = (Button) findViewById(R.id.loginBack);

        ImageView picture = (ImageView) findViewById(R.id.profilePicture);
        final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);
        picture.startAnimation(myAnim);
    }

}