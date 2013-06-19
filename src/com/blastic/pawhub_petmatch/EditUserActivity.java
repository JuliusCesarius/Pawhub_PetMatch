package com.blastic.pawhub_petmatch;

import java.io.BufferedInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaScannerConnection;
import android.media.MediaScannerConnection.MediaScannerConnectionClient;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class EditUserActivity extends Activity {

	ImageButton btnFinish;
	ImageView picUser;

	String name = "";

	private static int TAKE_PICTURE = 1;
	private static int SELECT_PICTURE = 2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_edit_user);

		btnFinish = (ImageButton) findViewById(R.id.btnEditAPet);
		picUser = (ImageView) findViewById(R.id.userPicture);
		name = Environment.getExternalStorageDirectory().getAbsolutePath()
				+ "/DCIM/Camera/test.jpg";

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.edit_user, menu);
		return true;
	}

	public void onBtnFinish_Click(View v) {

		Intent editPetIntend = new Intent(this, RateMyPetActivity.class);
		startActivity(editPetIntend);
	}

	public void onBtnUserPic_Click(View v) {

		/*
		 * Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE); int code
		 * = TAKE_PICTURE;
		 * 
		 * Uri output = Uri.fromFile(new File(name));
		 * intent.putExtra(MediaStore.EXTRA_OUTPUT, output);
		 * 
		 * Log.i("INTENTD", intent.toString());
		 * 
		 * startActivityForResult(intent, code);
		 */

		Intent pickIntent = new Intent();
		pickIntent.setType("image/*");
		pickIntent.setAction(Intent.ACTION_GET_CONTENT);

		Intent takePhotoIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

		String pickTitle = "Select or take a new Picture"; // Or get from
															// strings.xml
		Intent chooserIntent = Intent.createChooser(pickIntent, pickTitle);
		chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS,
				new Intent[] { takePhotoIntent });

		startActivityForResult(chooserIntent, 3);

	}

	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		
		Log.i("REQUEST CODE",""+requestCode);
		Log.i("REQUEST CODE",""+resultCode);
			if (data != null) {
				
				/**
				 * En el caso de una vista previa, obtenemos el extra “data” del
				 * intent y lo mostramos en el ImageView
				 */
				if (data.hasExtra("data")) {
					picUser.setImageBitmap((Bitmap) data
							.getParcelableExtra("data"));
				}
				/**
				 * De lo contrario es una imagen completa
				 */
			} else {
				/**
				 * A partir del nombre del archivo ya definido lo buscamos y
				 * creamos el bitmap para el ImageView
				 */
				picUser.setImageBitmap(BitmapFactory.decodeFile(name));
				/**
				 * Para guardar la imagen en la galería, utilizamos una conexión
				 * a un MediaScanner
				 */
				new MediaScannerConnectionClient() {
					private MediaScannerConnection msc = null;
					{
						msc = new MediaScannerConnection(
								getApplicationContext(), this);
						msc.connect();
					}

					public void onMediaScannerConnected() {
						msc.scanFile(name, null);
					}

					public void onScanCompleted(String path, Uri uri) {
						msc.disconnect();
					}
				};
			}
			
		/*else if (requestCode == SELECT_PICTURE) {
			Uri selectedImage = data.getData();
			InputStream is;
			try {
				is = getContentResolver().openInputStream(selectedImage);
				BufferedInputStream bis = new BufferedInputStream(is);
				Bitmap bitmap = BitmapFactory.decodeStream(bis);
				picUser.setImageBitmap(bitmap);
			} catch (FileNotFoundException e) {
			}
		}*/
	}
}
