# LogPeople

A minimal Android app that demonstrates **runtime permission handling** and **reading device contacts** via the Android `ContentResolver` API.

Built as a learning exercise for:
- Requesting `READ_CONTACTS` permission at runtime (Android 6.0+)
- Using `ContentResolver` + `ContactsContract` to query the contacts database
- Logging data to Logcat with `android.util.Log`

---

## What it does

1. On launch, checks whether the app has `READ_CONTACTS` permission.
2. If not, prompts the user with the system permission dialog.
3. Once granted, queries all contacts and logs to Logcat:
   - Total contact count
   - ID and display name of the 5th contact (if ≥ 5 contacts exist)

Output is visible in Android Studio's **Logcat** filtered by the tag `ContactLogger`.

---

## Tech stack

| Component | Detail |
|---|---|
| Language | Java |
| Min SDK | Android 6.0 (API 23) for runtime permissions |
| Build | Gradle (Kotlin DSL) |
| Key APIs | `ContentResolver`, `ContactsContract`, `ActivityCompat` |

---

## Project structure

```
app/
└── src/main/java/com/example/contactlogger/
    ├── MainActivity.java      # Permission request + entry point
    └── ContactLogger.java     # Contact query + Logcat output
```

---

## Running the app

1. Open in **Android Studio**.
2. Connect a device or start an emulator (with contacts added).
3. Run the app — accept the contacts permission.
4. Open **Logcat** and filter by `ContactLogger` to see the output.

---

## License

MIT