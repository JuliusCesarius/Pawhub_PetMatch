package com.blastic.pawhub_petmatch;

import java.io.BufferedInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaScannerConnection;
import android.media.MediaScannerConnection.MediaScannerConnectionClient;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;

import com.blastic.utilities.ActionBarHandler;


@SuppressLint("SimpleDateFormat")
public class EditUserActivity extends Activity {

	private ImageView pickPhoto;
	private ImageView takePhoto;
	private static int TAKE_PICTURE = 1;
	private static int SELECT_PICTURE = 0;
	private String name = "";
	public int code;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_edit_user);
		
		ActionBarHandler.setActionBar(this);

		pickPhoto = (ImageView) findViewById(R.id.userPickPicture);
		takePhoto = (ImageView) findViewById(R.id.userTakePicture);
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("-mm-ss");
		String newPicFile = "Bild" + df.format(date) + ".jpg";

		name = Environment.getExternalStorageDirectory().getAbsolutePath()
				+ "/DCIM/Camera/" + newPicFile;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void onBtnFinish_Click(View v) {
		Intent ratePetIntend = new Intent(this, MainTabsActivity.class);
		startActivity(ratePetIntend);
	}
	
	public void onBtnMore_Click(View v) {
		Intent editPetIntend = new Intent(this, EditPetActivity.class);
		startActivity(editPetIntend);
	}
	
	public void onBtnUserTakePic_Click(View v) {

		// showUserDialog();

		Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
		startActivityForResult(cameraIntent, TAKE_PICTURE);

	}

	public void onBtnPickUserPic_Click(View v) {

		// showUserDialog();

		Intent galeryIntent = new Intent(Intent.ACTION_PICK,
				android.provider.MediaStore.Images.Media.INTERNAL_CONTENT_URI);
		startActivityForResult(galeryIntent, SELECT_PICTURE);

	}

	/*public void showUserDialog() {
		FragmentManager fragment = getSupportFragmentManager();
		ChoorserDialog chooser = new ChoorserDialog();

		chooser.show(fragment, "Dialog");
	}*/

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		Log.i("prueba", "result");
		/**
		 * Se revisa si la imagen viene de la cámara (TAKE_PICTURE) o de la
		 * galería (SELECT_PICTURE)
		 */
		if (requestCode == TAKE_PICTURE) {
			/**
			 * Si se reciben datos en el intent tenemos una vista previa
			 * (thumbnail)
			 */
			if (data != null) {
				/**
				 * En el caso de una vista previa, obtenemos el extra “data” del
				 * intent y lo mostramos en el ImageView
				 */
				if (data.hasExtra("data")) {
					takePhoto.setImageBitmap((Bitmap) data
							.getParcelableExtra("data"));
					pickPhoto.setVisibility(View.INVISIBLE);
					/**
					 * Para guardar la imagen en la galería, utilizamos una
					 * conexión a un MediaScanner
					 */
					new MediaScannerConnectionClient() {
						private MediaScannerConnection msc = null;
						{
							msc = new MediaScannerConnection(
									getApplicationContext(), this);
							msc.connect();
						}

						@Override
						public void onMediaScannerConnected() {
							msc.scanFile(name, null);
						}

						@Override
						public void onScanCompleted(String path, Uri uri) {
							msc.disconnect();
						}
					};
				} 
				}
			}else if (requestCode == SELECT_PICTURE) {
				Log.i("prueba", "select");
				Uri selectedImage = data.getData();
				InputStream is;
				try {
					is = getContentResolver()
							.openInputStream(selectedImage);
					BufferedInputStream bis = new BufferedInputStream(is);
					Bitmap bitmap = BitmapFactory.decodeStream(bis);
					pickPhoto.setVisibility(View.INVISIBLE);
					takePhoto.setImageBitmap(bitmap);
				} catch (FileNotFoundException e) {
				}
		}
	}

}
