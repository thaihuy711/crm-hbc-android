package bys.crm.hbc.views;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;

import bys.crm.hbc.R;


public class RoundedConnerImageView extends ImageView {

	public static final String TAG = "RoundedImageView";
	public static final int DEFAULT_RADIUS = 0;
	public static final int DEFAULT_BORDER_WIDTH = 0;
	protected static final ScaleType[] sScaleTypeArray = { ScaleType.MATRIX,
			ScaleType.FIT_XY, ScaleType.FIT_START, ScaleType.FIT_CENTER,
			ScaleType.FIT_END, ScaleType.CENTER, ScaleType.CENTER_CROP,
			ScaleType.CENTER_INSIDE };
	protected int mCornerRadius = DEFAULT_RADIUS;
	protected int mBorderWidth = DEFAULT_BORDER_WIDTH;
	protected ColorStateList mBorderColor = ColorStateList
			.valueOf(RoundedDrawable.DEFAULT_BORDER_COLOR);
	protected boolean mRoundBackground = false;
	protected boolean mOval = false;
	protected Drawable mDrawable;
	protected Drawable mBackgroundDrawable;
	protected ScaleType mScaleType;

	public RoundedConnerImageView(Context context) {
		super(context);
	}

	public RoundedConnerImageView(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public RoundedConnerImageView(Context context, AttributeSet attrs,
                                  int defStyle) {
		super(context, attrs, defStyle);

		TypedArray a = context.obtainStyledAttributes(attrs,
				R.styleable.RoundedConnerImageView, defStyle, 0);

		int index = a.getInt(
				R.styleable.RoundedConnerImageView_android_scaleType, -1);
		if (index >= 0) {
			setScaleType(sScaleTypeArray[index]);
		}

		mCornerRadius = a.getDimensionPixelSize(
				R.styleable.RoundedConnerImageView_corner_radius, -1);
		mBorderWidth = a.getDimensionPixelSize(
				R.styleable.RoundedConnerImageView_border_width, -1);

		// don't allow negative values for radius and border
		if (mCornerRadius < 0) {
			mCornerRadius = DEFAULT_RADIUS;
		}
		if (mBorderWidth < 0) {
			mBorderWidth = DEFAULT_BORDER_WIDTH;
		}

		mBorderColor = a
				.getColorStateList(R.styleable.RoundedConnerImageView_border_color);
		if (mBorderColor == null) {
			mBorderColor = ColorStateList
					.valueOf(RoundedDrawable.DEFAULT_BORDER_COLOR);
		}

		mRoundBackground = a.getBoolean(
				R.styleable.RoundedConnerImageView_round_background, false);
		mOval = a.getBoolean(R.styleable.RoundedConnerImageView_is_oval, false);

		updateDrawableAttrs();
		updateBackgroundDrawableAttrs();

		a.recycle();
	}

	@Override
	protected void drawableStateChanged() {
		super.drawableStateChanged();
		invalidate();
	}

	/**
	 * Return the current scale type in use by this ImageView.
	 * 
	 * @attr ref android.R.styleable#ImageView_scaleType
	 * @see ScaleType
	 */
	@Override
	public ScaleType getScaleType() {
		return mScaleType;
	}

	/**
	 * Controls how the image should be resized or moved to match the size of
	 * this ImageView.
	 * 
	 * @param scaleType
	 *            The desired scaling mode.
	 * @attr ref android.R.styleable#ImageView_scaleType
	 */

	@Override
	public void setScaleType(ScaleType scaleType) {
		if (scaleType == null) {
			throw new NullPointerException();
		}

		if (mScaleType != scaleType) {
			mScaleType = scaleType;

			switch (scaleType) {
			case CENTER:
			case CENTER_CROP:
			case CENTER_INSIDE:
			case FIT_CENTER:
			case FIT_START:
			case FIT_END:
			case FIT_XY:
				super.setScaleType(ScaleType.FIT_XY);
				break;
			default:
				super.setScaleType(scaleType);
				break;
			}

			updateDrawableAttrs();
			updateBackgroundDrawableAttrs();
			invalidate();
		}
	}

	@Override
	public void setImageDrawable(Drawable drawable) {
		if (drawable != null) {
			mDrawable = RoundedDrawable.fromDrawable(drawable);
			updateDrawableAttrs();
		} else {
			mDrawable = null;
		}
		super.setImageDrawable(mDrawable);
	}

	public void setImageBitmap(Bitmap bm) {
		if (bm != null) {
			mDrawable = new RoundedDrawable(bm);
			updateDrawableAttrs();
		} else {
			mDrawable = null;
		}
		super.setImageDrawable(mDrawable);
	}

	@Override
	public void setBackground(Drawable background) {
		setBackgroundDrawable(background);
	}

	protected void updateDrawableAttrs() {
		updateAttrs(mDrawable, false);
	}

	protected void updateBackgroundDrawableAttrs() {
		updateAttrs(mBackgroundDrawable, true);
	}

	protected void updateAttrs(Drawable drawable, boolean background) {
		if (drawable == null) {
			return;
		}

		if (drawable instanceof RoundedDrawable) {
			((RoundedDrawable) drawable)
					.setScaleType(mScaleType)
					.setCornerRadius(
							!mRoundBackground && background ? 0 : mCornerRadius)
					.setBorderWidth(
							!mRoundBackground && background ? 0 : mBorderWidth)
					.setBorderColors(mBorderColor).setOval(mOval);
		} else if (drawable instanceof LayerDrawable) {
			// loop through layers to and set drawable attrs
			LayerDrawable ld = ((LayerDrawable) drawable);
			int layers = ld.getNumberOfLayers();
			for (int i = 0; i < layers; i++) {
				updateAttrs(ld.getDrawable(i), background);
			}
		}
	}

	@Override
	@Deprecated
	public void setBackgroundDrawable(Drawable background) {
		mBackgroundDrawable = RoundedDrawable.fromDrawable(background);
		updateBackgroundDrawableAttrs();
		super.setBackgroundDrawable(mBackgroundDrawable);
	}

	public int getCornerRadius() {
		return mCornerRadius;
	}

	public void setCornerRadius(int radius) {
		if (mCornerRadius == radius) {
			return;
		}

		mCornerRadius = radius;
		updateDrawableAttrs();
		updateBackgroundDrawableAttrs();
	}

	public int getBorderWidth() {
		return mBorderWidth;
	}

	public void setBorderWidth(int width) {
		if (mBorderWidth == width) {
			return;
		}

		mBorderWidth = width;
		updateDrawableAttrs();
		updateBackgroundDrawableAttrs();
		invalidate();
	}

	public int getBorderColor() {
		return mBorderColor.getDefaultColor();
	}

	public void setBorderColor(int color) {
		setBorderColors(ColorStateList.valueOf(color));
	}

	public ColorStateList getBorderColors() {
		return mBorderColor;
	}

	public void setBorderColors(ColorStateList colors) {
		if (mBorderColor.equals(colors)) {
			return;
		}

		mBorderColor = (colors != null) ? colors : ColorStateList
				.valueOf(RoundedDrawable.DEFAULT_BORDER_COLOR);
		updateDrawableAttrs();
		updateBackgroundDrawableAttrs();
		if (mBorderWidth > 0) {
			invalidate();
		}
	}

	public boolean isOval() {
		return mOval;
	}

	public void setOval(boolean oval) {
		mOval = oval;
		updateDrawableAttrs();
		updateBackgroundDrawableAttrs();
		invalidate();
	}

	@Override
	public void setImageResource(int resId) {
		super.setImageResource(resId);
		setImageDrawable(getDrawable());
	}

	public boolean isRoundBackground() {
		return mRoundBackground;
	}

	public void setRoundBackground(boolean roundBackground) {
		if (mRoundBackground == roundBackground) {
			return;
		}

		mRoundBackground = roundBackground;
		updateBackgroundDrawableAttrs();
		invalidate();
	}
}
