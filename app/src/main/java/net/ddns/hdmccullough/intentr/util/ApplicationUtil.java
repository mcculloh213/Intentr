package net.ddns.hdmccullough.intentr.util;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.util.Log;

import net.ddns.hdmccullough.intentr.model.AppInfo;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;

public class ApplicationUtil {
    private static final String TAG = ApplicationUtil.class.getSimpleName();

    private static ApplicationUtil Instance;

    public static ApplicationUtil getInstance() {
        if (Instance == null) {
            synchronized (ApplicationUtil.class) {
                if (Instance == null) {
                    Instance = new ApplicationUtil();
                }
            }
        }

        return Instance;
    }

    private ApplicationUtil() {

    }

    public List<AppInfo> getLaunchApplications(@NonNull Context context) {
        Log.d(TAG, "getLaunchApplication");

        ArrayList<AppInfo> applications = new ArrayList<>();
        PackageManager manager = context.getPackageManager();

        Intent main = new Intent(Intent.ACTION_MAIN, null);
        main.addCategory(Intent.CATEGORY_LAUNCHER);

        List<ResolveInfo> info = manager.queryIntentActivities(main, 0);

        for (ResolveInfo r : info) {
            applications.add(
                    new AppInfo(
                            r.loadLabel(manager),
                            r.activityInfo.packageName,
                            r.activityInfo.loadIcon(manager)
                    )
            );
        }

        return applications;
    }
}
