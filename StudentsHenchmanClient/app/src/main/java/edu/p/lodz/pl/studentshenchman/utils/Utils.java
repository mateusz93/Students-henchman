package edu.p.lodz.pl.studentshenchman.utils;

import android.support.v7.widget.Toolbar;

/**
 * Created by Michał on 2016-10-09.
 */
public class Utils {

    public static Toolbar prepareToolbar(Toolbar toolbar, int title, int icon) {
        toolbar.setTitle(title);
        toolbar.setNavigationIcon(icon);

        return toolbar;
    }
}
