package com.thiagoneves.weatherapp.util;

import android.content.res.ColorStateList;

import androidx.annotation.NonNull;

import com.thiagoneves.weatherapp.R;

public class ViewUtil {

    @NonNull
    public static ColorStateList getColorStateList() {
        ColorStateList colorStateList = new ColorStateList(
                new int[][]{
                        new int[]{-android.R.attr.state_checked},
                        new int[]{android.R.attr.state_checked}
                },
                new int[]{
                        R.color.darkGray, R.color.radioTint
                }
        );
        return colorStateList;
    }
}
