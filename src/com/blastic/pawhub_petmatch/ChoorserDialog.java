package com.blastic.pawhub_petmatch;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaScannerConnection;
import android.media.MediaScannerConnection.MediaScannerConnectionClient;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class ChoorserDialog extends DialogFragment {

	private static int REQUEST_CAMERA = 1;
	private static final int REQUEST_SELECT_FOTO = 0;
	private String path;
	public View view2;
	public Intent cameraIntent;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub

		getDialog().setTitle("Elija una opción...");

		View view = inflater.inflate(R.layout.dialog_fragment_chooser,
				container);
		view2 = inflater.inflate(R.layout.activity_edit_user, container);

		Button btnCamera = (Button) view.findViewById(R.id.dialog_btnCamara);
		Button btnGalery = (Button) view.findViewById(R.id.dialog_btnGalery);

		btnCamera.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Log.i("Presionó", "Camara");
				cameraIntent = new Intent(
				android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
				startActivityForResult(cameraIntent, REQUEST_CAMERA);
				
			}
		});

		btnGalery.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Log.i("Presionó", "Galery");
				if (path != null) {
					File imgFile = new File(path);
					if (imgFile.exists()) {
						Intent galeryIntent = new Intent(
								Intent.ACTION_PICK,
								android.provider.MediaStore.Images.Media.INTERNAL_CONTENT_URI);
						startActivityForResult(galeryIntent,
								REQUEST_SELECT_FOTO);

					}
				}
			}
		});

		return view;
	}

//	@Override
//	public void onActivityResult(int requestCode, int resultCode, Intent data) {
//		Log.i("Presionó", "Camara");
//		if (requestCode == REQUEST_CAMERA) {
//			Log.i("Presionó", "Camara");
//			ImageView iv = (ImageView) view2.findViewById(R.id.userPicture);
//			iv.setImageBitmap(BitmapFactory.decodeFile(path));
//			/**
//			 * Para guardar la imagen en la galer’a, utilizamos una conexi—n a
//			 * un MediaScanner
//			 */
//			new MediaScannerConnectionClient() {
//				private MediaScannerConnection msc = null;
//				{
//					msc = new MediaScannerConnection(view2.getContext(), this);
//					msc.connect();
//				}
//
//				public void onMediaScannerConnected() {
//					msc.scanFile(path, null);
//				}
//
//				public void onScanCompleted(String path, Uri uri) {
//					msc.disconnect();
//				}
//			};
//			dismiss();
//		} else if (requestCode == REQUEST_SELECT_FOTO) {
//			Log.i("Presionó", "Camara");
//			Uri selectedImage = data.getData();
//			InputStream is;
//			try {
//				is = view2.getContext().getContentResolver()
//						.openInputStream(selectedImage);
//				BufferedInputStream bis = new BufferedInputStream(is);
//				Bitmap bitmap = BitmapFactory.decodeStream(bis);
//				ImageView iv = (ImageView) view2.findViewById(R.id.userPicture);
//				iv.setImageBitmap(bitmap);
//			} catch (FileNotFoundException e) {
//			}
//			dismiss();
//		}
//	}
	
}
