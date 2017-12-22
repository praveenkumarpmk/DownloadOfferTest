package app.newskaro.com.newskaro.util;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import timber.log.Timber;


public class SoftKeyHandler {

    public static void closeKeyboard(Activity activity) {
        try {
            View view = activity.getCurrentFocus();
            if (view != null) {
                InputMethodManager mgr = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
                mgr.hideSoftInputFromWindow(view.getWindowToken(), 0);

            }

        } catch (Exception e) {
            Timber.e("Exception while closing the softkeypad");
            Timber.e("exception: %s", e.getMessage());
        }
    }

    public static void openKeyboard(Activity activity, EditText editText) {
        try {

            if (editText != null) {
                InputMethodManager mgr = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
                // editText.requestFocus();
                mgr.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);
                mgr.showSoftInput(editText, InputMethodManager.SHOW_IMPLICIT);
            }
        } catch (Exception e) {
            Timber.e("Exception while opening the softkeypad");
            Timber.e("exception: %s", e.getMessage());
        }

    }

    public static void openKeyboard(EditText editText) {
        try {

            if (editText != null) {
                InputMethodManager mgr = (InputMethodManager) editText.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                editText.requestFocus();
                mgr.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);
                mgr.showSoftInput(editText, InputMethodManager.SHOW_IMPLICIT);
            }
        } catch (Exception e) {
            Timber.e("Exception while opening the softkeypad");
            Timber.e("exception: %s", e.getMessage());
        }

    }

    public static void openKeyboard(Activity activity)
    {
        InputMethodManager mgr = (InputMethodManager)activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        mgr.toggleSoftInput(InputMethodManager.SHOW_FORCED,
                InputMethodManager.HIDE_IMPLICIT_ONLY);
    }
}
