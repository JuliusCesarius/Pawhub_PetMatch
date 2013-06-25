package com.blastic.utilities;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

public final class Images {
	
	
	public static Bitmap GetBitmapClippedCircle(Bitmap bitmap) {

        final int width = bitmap.getWidth();
        final int height = bitmap.getHeight();
        final Bitmap outputBitmap = Bitmap.createBitmap(width, height, Config.ARGB_8888);

        final Path path = new Path();
        path.addCircle(
                  (float)(width / 2)
                , (float)(height / 2)
                , (float) Math.min(width, (height / 2))
                , Path.Direction.CCW);

        final Canvas canvas = new Canvas(outputBitmap);
        canvas.clipPath(path);
        canvas.drawBitmap(bitmap, 0, 0, null);
        return outputBitmap;
    }
	
	public static Bitmap getRoundedCornerBitmap(Bitmap bitmap) {
		Bitmap output = Bitmap.createBitmap(bitmap.getWidth(),
		    bitmap.getHeight(), Config.ARGB_8888);
		Canvas canvas = new Canvas(output);

		final int color = 0xff424242;
		final Paint paint = new Paint();
		final Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
		final RectF rectF = new RectF(rect);
		final float roundPx = 12;

		paint.setAntiAlias(true);
		canvas.drawARGB(0, 0, 0, 0);
		paint.setColor(color);
		canvas.drawRoundRect(rectF, roundPx, roundPx, paint);

		paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
		canvas.drawBitmap(bitmap, rect, rect, paint);

		return output;
	}

	public static void cropImage(int idImageResource, int idImageView, Activity activity)
	{
		Bitmap tempBMP = BitmapFactory.decodeResource(activity.getResources(),idImageResource);
		Drawable drawable = new BitmapDrawable(activity.getResources(),Images.GetBitmapClippedCircle(tempBMP));
		
		ImageView imageView = (ImageView)activity.findViewById(idImageView);
		imageView.setImageDrawable(drawable);
		
	}
	
	public static void cropImageCorner(int idImageResource, int idImageView, Activity activity)
	{
		Bitmap tempBMP = BitmapFactory.decodeResource(activity.getResources(),idImageResource);
		Drawable drawable = new BitmapDrawable(activity.getResources(),Images.getRoundedCornerBitmap(tempBMP));
		
		ImageView imageView = (ImageView)activity.findViewById(idImageView);
		imageView.setImageDrawable(drawable);
		
	}
	
	public static Drawable cropImageCorner(int idImageResource, int idImageView, Resources resources)
	{
		Bitmap tempBMP = BitmapFactory.decodeResource(resources,idImageResource);
		Drawable drawable = new BitmapDrawable(resources,Images.getRoundedCornerBitmap(tempBMP));
		
		return drawable;
		
	}
	
	
	public static Drawable cropImageCorner(Drawable drawable, Activity activity)
	{
		Bitmap bitmap = drawableToBitmap(drawable);
		Drawable output = new BitmapDrawable(activity.getResources(),Images.getRoundedCornerBitmap(bitmap));
		return output;
	}
	
	public static Bitmap drawableToBitmap (Drawable drawable) {
	    if (drawable instanceof BitmapDrawable) {
	        return ((BitmapDrawable)drawable).getBitmap();
	    }

	    int width = drawable.getIntrinsicWidth();
	    width = width > 0 ? width : 1;
	    int height = drawable.getIntrinsicHeight();
	    height = height > 0 ? height : 1;

	    Bitmap bitmap = Bitmap.createBitmap(width, height, Config.ARGB_8888);
	    Canvas canvas = new Canvas(bitmap); 
	    drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
	    drawable.draw(canvas);

	    return bitmap;
	}
}
