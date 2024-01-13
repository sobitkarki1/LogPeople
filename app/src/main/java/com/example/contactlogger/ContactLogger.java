package com.example.contactlogger;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Build;
import android.provider.ContactsContract;
import android.util.Log;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class ContactLogger {

    static final int REQUEST_CONTACTS_PERMISSION = 1;

    public static void logContacts(Context context) {
        // Check runtime permission for Android 6.0 and above
        if (ContextCompat.checkSelfPermission(context, android.Manifest.permission.READ_CONTACTS)
                != PackageManager.PERMISSION_GRANTED) {

            // Request the permission
            ActivityCompat.requestPermissions((MainActivity) context,
                    new String[]{android.Manifest.permission.READ_CONTACTS},
                    REQUEST_CONTACTS_PERMISSION
            );

            return;
        }


        ContentResolver contentResolver = context.getContentResolver();

        // Query to get all contacts
        Cursor cursor = contentResolver.query(
                ContactsContract.Contacts.CONTENT_URI,
                null,
                null,
                null,
                null
        );

        if (cursor != null) {
            try {
                int contactCount = cursor.getCount();
                Log.d("ContactLogger", "Number of contacts: " + contactCount);

                // Check if there is at least 5 contacts
                if (contactCount >= 5) {
                    // Move to the 5th contact
                    cursor.moveToPosition(4);

                    // Get contact details
                    @SuppressLint("Range") String contactId = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));
                    @SuppressLint("Range") String displayName = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));

                    Log.d("ContactLogger", "5th Contact Details:");
                    Log.d("ContactLogger", "Contact ID: " + contactId);
                    Log.d("ContactLogger", "Display Name: " + displayName);
                    // You can log more details as needed
                } else {
                    Log.d("ContactLogger", "There are less than 5 contacts.");
                }
            } finally {
                cursor.close();
            }
        }
    }
}
