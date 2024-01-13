package com.example.contactlogger;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.example.contactlogger.ContactLogger;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Check and request permissions if needed
        checkAndRequestPermissions();
    }


    private void checkAndRequestPermissions() {
        // Check runtime permission for Android 6.0 and above
        if (checkSelfPermission(android.Manifest.permission.READ_CONTACTS)
                != android.content.pm.PackageManager.PERMISSION_GRANTED) {

            // Request the permission
            requestPermissions(new String[]{android.Manifest.permission.READ_CONTACTS},
                    ContactLogger.REQUEST_CONTACTS_PERMISSION);
        } else {
            // Permission already granted, call logContacts
            logContacts();
        }

    }

    private void logContacts() {
        // Call the logContacts method here
        ContactLogger.logContacts(this);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == ContactLogger.REQUEST_CONTACTS_PERMISSION) {
            if (grantResults.length > 0 && grantResults[0] == android.content.pm.PackageManager.PERMISSION_GRANTED) {
                // Permission granted, call logContacts
                logContacts();
            } else {
                // Permission denied, handle accordingly
                // You may want to inform the user or take appropriate action
            }
        }
    }
}