package net.ddns.hdmccullough.intentr.viewmodel;

import android.app.Application;
import android.graphics.drawable.Drawable;

import net.ddns.hdmccullough.intentr.util.ApplicationUtil;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

public class LauncherViewModel extends AndroidViewModel {
    private static final String TAG = LauncherViewModel.class.getSimpleName();

    private final ArrayList<Object> mApplicationsList = new ArrayList<>();
    public LauncherViewModel(@NonNull Application application) {
        super(application);

        mApplicationsList.addAll(ApplicationUtil.getInstance().getLaunchApplications(application));
    }
}
