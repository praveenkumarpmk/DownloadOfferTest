package app.newskaro.com.newskaro.util;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.TextView;

public class SnackBarFactory {

    public static Snackbar createSnackbar(Context context, View view, String message) {
        Snackbar snackbar = Snackbar.make(view, message, Snackbar.LENGTH_LONG);
        //ViewGroup group = (ViewGroup) snackbar.getView();
        //group.setBackgroundColor(ContextCompat.getColor(context, R.color.primary_light));
        snackbar.show();
        return snackbar;
    }

    public static Snackbar createSnackbarIndefinite(Context context, View view, String message) {
        Snackbar snackbar = Snackbar.make(view, message, Snackbar.LENGTH_INDEFINITE);
        //ViewGroup group = (ViewGroup) snackbar.getView();
        //group.setBackgroundColor(ContextCompat.getColor(context, R.color.primary_light));
        snackbar.show();
        return snackbar;
    }

    public static Snackbar createSnackbarMultiLine(Context context, View view, String message) {
        Snackbar snackbar = Snackbar.make(view, message, Snackbar.LENGTH_SHORT);
        TextView snackbarTextView = snackbar.getView().findViewById(android.support.design.R.id.snackbar_text);
        snackbarTextView.setMaxLines(999);
        snackbar.show();
        return snackbar;

    }


}
