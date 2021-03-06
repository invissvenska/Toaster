package nl.invissvenska.toaster;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.CheckResult;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.StringRes;

@SuppressLint("InflateParams")
public class Toaster {

    private static final Typeface LOADED_TOAST_TYPEFACE = Typeface.create("sans-serif-condensed", Typeface.NORMAL);
    private static Typeface currentTypeface = LOADED_TOAST_TYPEFACE;
    private static int textSize = 16;

    private static int gravity = Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL;
    private static int offsetX = 0;
    private static int offsetY = 63;
    private static float horizontalMargin = 0f;
    private static float verticalMargin = 0f;

    private static boolean tintIcon = true;
    private static boolean allowQueue = true;
    private static boolean material = false;

    private static Toast lastToast = null;

    public static final int LENGTH_SHORT = Toast.LENGTH_SHORT;
    public static final int LENGTH_LONG = Toast.LENGTH_LONG;


    private Toaster() {
        // avoiding instantiation
    }

    @CheckResult
    public static Toast normal(@NonNull Context context, @StringRes int message) {
        return normal(context, context.getString(message), Toast.LENGTH_SHORT, null, false);
    }

    @CheckResult
    public static Toast normal(@NonNull Context context, @NonNull CharSequence message) {
        return normal(context, message, Toast.LENGTH_SHORT, null, false);
    }

    @CheckResult
    public static Toast normal(@NonNull Context context, @StringRes int message, Drawable icon) {
        return normal(context, context.getString(message), Toast.LENGTH_SHORT, icon, true);
    }

    @CheckResult
    public static Toast normal(@NonNull Context context, @NonNull CharSequence message, Drawable icon) {
        return normal(context, message, Toast.LENGTH_SHORT, icon, true);
    }

    @CheckResult
    public static Toast normal(@NonNull Context context, @StringRes int message, int duration) {
        return normal(context, context.getString(message), duration, null, false);
    }

    @CheckResult
    public static Toast normal(@NonNull Context context, @NonNull CharSequence message, int duration) {
        return normal(context, message, duration, null, false);
    }

    @CheckResult
    public static Toast normal(@NonNull Context context, @StringRes int message, int duration,
                               Drawable icon) {
        return normal(context, context.getString(message), duration, icon, true);
    }

    @CheckResult
    public static Toast normal(@NonNull Context context, @NonNull CharSequence message, int duration, Drawable icon) {
        return normal(context, message, duration, icon, true);
    }

    @CheckResult
    public static Toast normal(@NonNull Context context, @StringRes int message, int duration, Drawable icon, boolean withIcon) {
        return custom(context, context.getString(message), icon, ToasterUtils.getColor(context, R.color.normalColor),
                ToasterUtils.getColor(context, R.color.defaultTextColor), duration, withIcon, true);
    }

    @CheckResult
    public static Toast normal(@NonNull Context context, @NonNull CharSequence message, int duration, Drawable icon, boolean withIcon) {
        return custom(context, message, icon, ToasterUtils.getColor(context, R.color.normalColor),
                ToasterUtils.getColor(context, R.color.defaultTextColor), duration, withIcon, true);
    }

    @CheckResult
    public static Toast warning(@NonNull Context context, @StringRes int message) {
        return warning(context, context.getString(message), Toast.LENGTH_SHORT, true);
    }

    @CheckResult
    public static Toast warning(@NonNull Context context, @NonNull CharSequence message) {
        return warning(context, message, Toast.LENGTH_SHORT, true);
    }

    @CheckResult
    public static Toast warning(@NonNull Context context, @StringRes int message, int duration) {
        return warning(context, context.getString(message), duration, true);
    }

    @CheckResult
    public static Toast warning(@NonNull Context context, @NonNull CharSequence message, int duration) {
        return warning(context, message, duration, true);
    }

    @CheckResult
    public static Toast warning(@NonNull Context context, @StringRes int message, int duration, boolean withIcon) {
        return custom(context, context.getString(message), ToasterUtils.getDrawable(context, R.drawable.ic_error_outline_white_24dp),
                ToasterUtils.getColor(context, R.color.warningColor), ToasterUtils.getColor(context, R.color.defaultTextColor),
                duration, withIcon, true);
    }

    @CheckResult
    public static Toast warning(@NonNull Context context, @NonNull CharSequence message, int duration, boolean withIcon) {
        return custom(context, message, ToasterUtils.getDrawable(context, R.drawable.ic_error_outline_white_24dp),
                ToasterUtils.getColor(context, R.color.warningColor), ToasterUtils.getColor(context, R.color.defaultTextColor),
                duration, withIcon, true);
    }


    @CheckResult
    public static Toast info(@NonNull Context context, @StringRes int message) {
        return info(context, context.getString(message), Toast.LENGTH_SHORT, true);
    }

    @CheckResult
    public static Toast info(@NonNull Context context, @NonNull CharSequence message) {
        return info(context, message, Toast.LENGTH_SHORT, true);
    }

    @CheckResult
    public static Toast info(@NonNull Context context, @StringRes int message, int duration) {
        return info(context, context.getString(message), duration, true);
    }

    @CheckResult
    public static Toast info(@NonNull Context context, @NonNull CharSequence message, int duration) {
        return info(context, message, duration, true);
    }

    @CheckResult
    public static Toast info(@NonNull Context context, @StringRes int message, int duration, boolean withIcon) {
        return custom(context, context.getString(message), ToasterUtils.getDrawable(context, R.drawable.ic_info_outline_white_24dp),
                ToasterUtils.getColor(context, R.color.infoColor), ToasterUtils.getColor(context, R.color.defaultTextColor),
                duration, withIcon, true);
    }

    @CheckResult
    public static Toast info(@NonNull Context context, @NonNull CharSequence message, int duration, boolean withIcon) {
        return custom(context, message, ToasterUtils.getDrawable(context, R.drawable.ic_info_outline_white_24dp),
                ToasterUtils.getColor(context, R.color.infoColor), ToasterUtils.getColor(context, R.color.defaultTextColor),
                duration, withIcon, true);
    }

    @CheckResult
    public static Toast success(@NonNull Context context, @StringRes int message) {
        return success(context, context.getString(message), Toast.LENGTH_SHORT, true);
    }

    @CheckResult
    public static Toast success(@NonNull Context context, @NonNull CharSequence message) {
        return success(context, message, Toast.LENGTH_SHORT, true);
    }

    @CheckResult
    public static Toast success(@NonNull Context context, @StringRes int message, int duration) {
        return success(context, context.getString(message), duration, true);
    }

    @CheckResult
    public static Toast success(@NonNull Context context, @NonNull CharSequence message, int duration) {
        return success(context, message, duration, true);
    }

    @CheckResult
    public static Toast success(@NonNull Context context, @StringRes int message, int duration, boolean withIcon) {
        return custom(context, context.getString(message), ToasterUtils.getDrawable(context, R.drawable.ic_check_white_24dp),
                ToasterUtils.getColor(context, R.color.successColor), ToasterUtils.getColor(context, R.color.defaultTextColor),
                duration, withIcon, true);
    }

    @CheckResult
    public static Toast success(@NonNull Context context, @NonNull CharSequence message, int duration, boolean withIcon) {
        return custom(context, message, ToasterUtils.getDrawable(context, R.drawable.ic_check_white_24dp),
                ToasterUtils.getColor(context, R.color.successColor), ToasterUtils.getColor(context, R.color.defaultTextColor),
                duration, withIcon, true);
    }

    @CheckResult
    public static Toast error(@NonNull Context context, @StringRes int message) {
        return error(context, context.getString(message), Toast.LENGTH_SHORT, true);
    }

    @CheckResult
    public static Toast error(@NonNull Context context, @NonNull CharSequence message) {
        return error(context, message, Toast.LENGTH_SHORT, true);
    }

    @CheckResult
    public static Toast error(@NonNull Context context, @StringRes int message, int duration) {
        return error(context, context.getString(message), duration, true);
    }

    @CheckResult
    public static Toast error(@NonNull Context context, @NonNull CharSequence message, int duration) {
        return error(context, message, duration, true);
    }

    @CheckResult
    public static Toast error(@NonNull Context context, @StringRes int message, int duration, boolean withIcon) {
        return custom(context, context.getString(message), ToasterUtils.getDrawable(context, R.drawable.ic_clear_white_24dp),
                ToasterUtils.getColor(context, R.color.errorColor), ToasterUtils.getColor(context, R.color.defaultTextColor),
                duration, withIcon, true);
    }

    @CheckResult
    public static Toast error(@NonNull Context context, @NonNull CharSequence message, int duration, boolean withIcon) {
        return custom(context, message, ToasterUtils.getDrawable(context, R.drawable.ic_clear_white_24dp),
                ToasterUtils.getColor(context, R.color.errorColor), ToasterUtils.getColor(context, R.color.defaultTextColor),
                duration, withIcon, true);
    }

    @CheckResult
    public static Toast custom(@NonNull Context context, @StringRes int message, Drawable icon, int duration, boolean withIcon) {
        return custom(context, context.getString(message), icon, -1, ToasterUtils.getColor(context, R.color.defaultTextColor),
                duration, withIcon, false);
    }

    @CheckResult
    public static Toast custom(@NonNull Context context, @NonNull CharSequence message, Drawable icon, int duration, boolean withIcon) {
        return custom(context, message, icon, -1, ToasterUtils.getColor(context, R.color.defaultTextColor),
                duration, withIcon, false);
    }

    @CheckResult
    public static Toast custom(@NonNull Context context, @StringRes int message, @DrawableRes int iconRes, @ColorRes int tintColorRes, int duration, boolean withIcon, boolean shouldTint) {
        return custom(context, context.getString(message), ToasterUtils.getDrawable(context, iconRes),
                ToasterUtils.getColor(context, tintColorRes), ToasterUtils.getColor(context, R.color.defaultTextColor),
                duration, withIcon, shouldTint);
    }

    @CheckResult
    public static Toast custom(@NonNull Context context, @NonNull CharSequence message, @DrawableRes int iconRes, @ColorRes int tintColorRes, int duration, boolean withIcon, boolean shouldTint) {
        return custom(context, message, ToasterUtils.getDrawable(context, iconRes),
                ToasterUtils.getColor(context, tintColorRes), ToasterUtils.getColor(context, R.color.defaultTextColor),
                duration, withIcon, shouldTint);
    }

    @CheckResult
    public static Toast custom(@NonNull Context context, @StringRes int message, Drawable icon, @ColorRes int tintColorRes, int duration, boolean withIcon, boolean shouldTint) {
        return custom(context, context.getString(message), icon, ToasterUtils.getColor(context, tintColorRes),
                ToasterUtils.getColor(context, R.color.defaultTextColor), duration, withIcon, shouldTint);
    }

    @CheckResult
    public static Toast custom(@NonNull Context context, @StringRes int message, Drawable icon, @ColorRes int tintColorRes, @ColorRes int textColorRes, int duration, boolean withIcon, boolean shouldTint) {
        return custom(context, context.getString(message), icon, ToasterUtils.getColor(context, tintColorRes),
                ToasterUtils.getColor(context, textColorRes), duration, withIcon, shouldTint);
    }

    @SuppressLint("ShowToast")
    @CheckResult
    public static Toast custom(@NonNull Context context, @NonNull CharSequence message, Drawable icon, @ColorInt int tintColor, @ColorInt int textColor, int duration, boolean withIcon, boolean shouldTint) {
        final Toast currentToast = Toast.makeText(context, "", duration);
        final View toastLayout = ((LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.toast_layout, null);
        final ImageView toastIcon = toastLayout.findViewById(R.id.toast_icon);
        final TextView toastTextView = toastLayout.findViewById(R.id.toast_text);
        Drawable drawableFrame;

        if (shouldTint) {
            drawableFrame = ToasterUtils.tint9PatchDrawableFrame(context, tintColor, material);
        } else if (material) {
            drawableFrame = ToasterUtils.getDrawable(context, R.drawable.toast_frame_material);
        } else {
            drawableFrame = ToasterUtils.getDrawable(context, R.drawable.toast_frame);
        }
        ToasterUtils.setBackground(toastLayout, drawableFrame);

        if (withIcon) {
            if (icon == null) {
                throw new IllegalArgumentException("Avoid passing 'icon' as null if 'withIcon' is set to true");
            }
            ToasterUtils.setBackground(toastIcon, tintIcon ? ToasterUtils.tintIcon(icon, textColor) : icon);
        } else {
            toastIcon.setVisibility(View.GONE);
        }

        toastTextView.setText(message);
        toastTextView.setTextColor(textColor);
        toastTextView.setTypeface(currentTypeface);
        toastTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize);

        currentToast.setGravity(gravity, offsetX, offsetY);
        currentToast.setMargin(horizontalMargin, verticalMargin);
        currentToast.setView(toastLayout);

        if (!allowQueue) {
            if (lastToast != null) {
                lastToast.cancel();
            }
            lastToast = currentToast;
        }

        return currentToast;
    }

    public static class Config {
        private Typeface typeface = Toaster.currentTypeface;
        private int textSize = Toaster.textSize;

        private boolean tintIcon = Toaster.tintIcon;
        private boolean allowQueue = true;
        private boolean material = false;

        private int gravity = Toaster.gravity;
        private int offsetX = Toaster.offsetX;
        private int offsetY = Toaster.offsetY;
        private float horizontalMargin = Toaster.horizontalMargin;
        private float verticalMargin = Toaster.verticalMargin;

        private Config() {
            // avoiding instantiation
        }

        @CheckResult
        public static Config getInstance() {
            return new Config();
        }

        public static void reset() {
            Toaster.currentTypeface = LOADED_TOAST_TYPEFACE;
            Toaster.textSize = 16;
            Toaster.tintIcon = true;
            Toaster.allowQueue = true;
            Toaster.material = false;
            Toaster.gravity = Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL;
            Toaster.offsetX = 0;
            Toaster.offsetY = 63;
            Toaster.horizontalMargin = 0f;
            Toaster.verticalMargin = 0f;
        }

        @CheckResult
        public Config setToastTypeface(@NonNull Typeface typeface) {
            this.typeface = typeface;
            return this;
        }

        @CheckResult
        public Config setTextSize(int sizeInSp) {
            this.textSize = sizeInSp;
            return this;
        }

        @CheckResult
        public Config tintIcon(boolean tintIcon) {
            this.tintIcon = tintIcon;
            return this;
        }

        @CheckResult
        public Config allowQueue(boolean allowQueue) {
            this.allowQueue = allowQueue;
            return this;
        }

        @CheckResult
        public Config setMaterial(boolean material) {
            this.material = material;
            return this;
        }

        @CheckResult
        public Config setGravity(int gravity, int offsetX, int offsetY) {
            this.gravity = gravity;
            this.offsetX = offsetX;
            this.offsetY = offsetY;
            return this;
        }

        @CheckResult
        public Config setMargin(float horizontalMargin, float verticalMargin) {
            this.horizontalMargin = horizontalMargin;
            this.verticalMargin = verticalMargin;
            return this;
        }

        public void apply() {
            Toaster.currentTypeface = typeface;
            Toaster.textSize = textSize;
            Toaster.tintIcon = tintIcon;
            Toaster.allowQueue = allowQueue;
            Toaster.material = material;
            Toaster.gravity = gravity;
            Toaster.offsetX = offsetX;
            Toaster.offsetY = offsetY;
            Toaster.horizontalMargin = horizontalMargin;
            Toaster.verticalMargin = verticalMargin;
        }
    }
}
