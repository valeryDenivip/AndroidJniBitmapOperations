package com.jni.bitmap_operations;
import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.widget.ImageView;

/** just a demo activity to show some of the features of the library */
@TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
public class MainActivity extends Activity
  {
  private static final int IMAGE_RESID_TO_TEST =R.drawable.test;
  JniBitmapHolder          bitmapHolder        =new JniBitmapHolder();

  @Override
  protected void onCreate(final Bundle savedInstanceState)
    {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    //
    // original
    //
    final ImageView imageViewOriginal=(ImageView)findViewById(R.id.imageViewOriginal);
    final Bitmap b=BitmapFactory.decodeResource(getResources(),IMAGE_RESID_TO_TEST);
    imageViewOriginal.setImageBitmap(b);
    //
    // rotated 90 degress CCW
    //
    final ImageView imageViewRotated90degressCcw=(ImageView)findViewById(R.id.imageViewRotated90degressCcw);
    bitmapHolder.storeBitmap(b);
    bitmapHolder.rotateBitmapCcw90();
    imageViewRotated90degressCcw.setImageBitmap(bitmapHolder.getBitmapAndFree());
    //
    // rotated 90 degress CW
    //
    final ImageView imageViewRotated90degressCw=(ImageView)findViewById(R.id.imageViewRotated90degressCw);
    bitmapHolder.storeBitmap(b);
    bitmapHolder.rotateBitmapCw90();
    imageViewRotated90degressCw.setImageBitmap(bitmapHolder.getBitmapAndFree());
    
    //
    // rotated by any angle
    // math based on http://polymathprogrammer.com/2008/10/06/image-rotation-with-bilinear-interpolation/  - "Throwing values from source to destination"
    //
    final ImageView imageViewRotatedAnyAngle=(ImageView)findViewById(R.id.imageViewRotatedAnyAngle);
    bitmapHolder.storeBitmap(b);
    bitmapHolder.rotateBitmapByAngle(45);
    imageViewRotatedAnyAngle.setImageBitmap(bitmapHolder.getBitmapAndFree());
  

    //
    // cropped
    //
    final ImageView imageViewCropped=(ImageView)findViewById(R.id.imageViewCropped);
    bitmapHolder.storeBitmap(b);
    bitmapHolder.cropBitmap(b.getWidth()/4,b.getHeight()/4,b.getWidth()*3/4,b.getHeight()*3/4);
    imageViewCropped.setImageBitmap(bitmapHolder.getBitmapAndFree());
    //
    // scaled
    //
    final ImageView imageViewScaled=(ImageView)findViewById(R.id.imageViewScaled);
    // final Bitmap b2=resize(b,b.getWidth()/2,b.getHeight()*2);
    bitmapHolder.storeBitmap(b);
    bitmapHolder.scaleBitmap(b.getWidth()*2,b.getHeight());
    imageViewScaled.setImageBitmap(bitmapHolder.getBitmapAndFree());
    // imageViewScaled.setImageBitmap(b2);
    }
  }
