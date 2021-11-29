package timika.papua.myapplication;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.work.ExistingWorkPolicy;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final OneTimeWorkRequest request = new
                OneTimeWorkRequest.Builder(MyWorker.class).build();
        findViewById(R.id.button).setOnClickListener(view -> WorkManager.getInstance().enqueueUniqueWork(
                "Notifikasi",
                ExistingWorkPolicy.REPLACE,
                request));

        final OneTimeWorkRequest requestt = new
                OneTimeWorkRequest.Builder(MyWorker1.class).build();
        findViewById(R.id.button2).setOnClickListener(view -> WorkManager.getInstance().enqueueUniqueWork(
                "Notifikasi",
                ExistingWorkPolicy.REPLACE,
                requestt));
    }
}
