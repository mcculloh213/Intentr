package net.ddns.hdmccullough.intentr.model;

import android.graphics.drawable.Drawable;

public class AppInfo {
    private CharSequence mLabel;
    private CharSequence mPackage;
    private Drawable mIcon;

    public AppInfo(CharSequence label, CharSequence packageName, Drawable icon) {
        mLabel = label;
        mPackage = packageName;
        mIcon = icon;
    }

    public CharSequence getLabel() {
        return mLabel;
    }

    public CharSequence getPackage() {
        return mPackage;
    }

    public Drawable getIcon() {
        return mIcon;
    }
}
