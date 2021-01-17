package com.example.termproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.EmbossMaskFilter;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    MyGraphicView graphicView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Introducing IU Singer");


        Button nextBtn = findViewById(R.id.nextBtn);
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ////별도 XML사용하는 사용자가 지정한 토스트
                LayoutInflater inflater = getLayoutInflater();
                View layout = inflater.inflate(R.layout.toast,
                        (ViewGroup)findViewById(R.id.toast));
                TextView text = (TextView)layout.findViewById(R.id.toastText);
                text.setText("다음 페이지로 이동");
                Toast toast = new Toast(MainActivity.this);
                toast.setGravity(Gravity.CENTER, 0, 700);
                toast.setDuration(Toast.LENGTH_SHORT);
                toast.setView(layout);
                toast.show();

                    Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
                startActivity(intent);
            }
        });

        //이미지 활용을 하기위한 그래픽 view 생성
        LinearLayout pictureLayout = findViewById(R.id.picturelayout);
        graphicView = new MyGraphicView(this);
        pictureLayout.addView(graphicView);

        final GridView gv = (GridView) findViewById(R.id.gridView);
        MyGridAdapter gAdapter = new MyGridAdapter(this);
        gv.setAdapter(gAdapter);
    }
    //이미지 활용을 하기 위한 그래픽 view 클래스 생성
    private static  class MyGraphicView extends View{
        public MyGraphicView(Context context){
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            Bitmap picture = BitmapFactory.decodeResource(getResources(), R.drawable.mainiu);
            int picX = (this.getWidth()-picture.getWidth())/2;
            int picY = (this.getHeight()-picture.getHeight())/2;

            //블러링 효과 적용
            Paint paint = new Paint();
            BlurMaskFilter bMask;
            bMask = new BlurMaskFilter(50, BlurMaskFilter.Blur.NORMAL);
            paint.setMaskFilter(bMask);

            canvas.drawBitmap(picture, picX, picY, paint);
            picture.recycle();
        }
    }

    //메뉴 생성
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater mInflater = getMenuInflater();
        mInflater.inflate(R.menu.menu1, menu);
        return true;
    }
    @Override
    //메뉴 선택했을때 메서드 실행
    public boolean onOptionsItemSelected( MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu1: return true;
            case R.id.menu2: return true;
            case R.id.menu3:
                String text ="파일을 불러올 수 없습니다"; //오류날시 default값
                //res/raw폴더에 explain.text파일을 불러 문자열 text에 저장하고, Toast에 저장된 text값을 불러와서 보여준다.
                InputStream inputS = getResources().openRawResource(R.raw.explain);
                try {
                    byte[] txt = new byte[inputS.available()];
                    inputS.read(txt);
                    text = new String(txt);
                    inputS.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Toast.makeText(getApplicationContext(),text,Toast.LENGTH_LONG).show();
                return true;
        }

        return false;
    }

    //그리드뷰 클래스
    public class MyGridAdapter extends BaseAdapter {
                Context context;

        public MyGridAdapter(Context c) {
                    context = c;
          }

          public int getCount() {
            return albumID.length;
          }

        public Object getItem(int position) {
            // TODO Auto-generated method stub
            return null;
        }

        public long getItemId(int position) {
            // TODO Auto-generated method stub
            return 0;
        }
        Integer[] albumID = { R.drawable.iualbum1, R.drawable.iualbum2,
                R.drawable.iualbum3, R.drawable.iualbum4 };

        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageview = new ImageView(context);
            imageview.setLayoutParams(new GridView.LayoutParams(400, 500));
            imageview.setScaleType(ImageView.ScaleType.FIT_XY);
            imageview.setPadding(10, 10, 10, 10);

            imageview.setImageResource(albumID[position]);

            final int pos = position;
            imageview.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    View dialogView = (View) View.inflate(
                            MainActivity.this, R.layout.dialog, null);
                    AlertDialog.Builder dlg = new AlertDialog.Builder(
                            MainActivity.this);
                    ImageView ivAlbum = (ImageView) dialogView
                            .findViewById(R.id.ivAlbum);
                    //그리드뷰에 앨범이미지 저장.
                    ivAlbum.setImageResource(albumID[pos]);
                    //diaglog 선택에 따라서 타이틀과 메세지 변경
                    switch(pos){
                        case 0: dlg.setTitle("Modern Times"); dlg.setMessage("2013.10.8발매 (댄스) ");
                            dlg.setNegativeButton("닫기", null);
                            dlg.setPositiveButton("이동", null);
                            dlg.setPositiveButton("이동", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                  Toast.makeText(MainActivity.this, "앨범1 페이지로 이동합니다", Toast.LENGTH_SHORT).show();
                                  Intent intent = new Intent(getApplicationContext(), Album1Activity.class);
                                  startActivity(intent);
                                }
                            }); break;
                        case 1: dlg.setTitle("CHAT-SHIRE"); dlg.setMessage("2015.10.23발매 (댄스) ");
                            dlg.setNegativeButton("닫기", null);
                            dlg.setPositiveButton("이동", null);
                            dlg.setPositiveButton("이동", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Toast.makeText(MainActivity.this, "앨범2 페이지로 이동합니다", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(getApplicationContext(), Album2Activity.class);
                                    startActivity(intent);
                                }
                            }); break;
                        case 2: dlg.setTitle("Palette"); dlg.setMessage("2017.4.21발매 (발라드, 알앤비/어반) ");
                            dlg.setNegativeButton("닫기", null);
                            dlg.setPositiveButton("이동", null);
                            dlg.setPositiveButton("이동", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Toast.makeText(MainActivity.this, "앨범3 페이지로 이동합니다", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(getApplicationContext(), Album3Activity.class);
                                    startActivity(intent);
                                }
                            }); break;
                        case 3: dlg.setTitle("Love poem"); dlg.setMessage("2019.11.18발매 (락) ");
                            dlg.setNegativeButton("닫기", null);
                            dlg.setPositiveButton("이동", null);
                            dlg.setPositiveButton("이동", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Toast.makeText(MainActivity.this, "앨범4 페이지로 이동합니다", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(getApplicationContext(), Album4Activity.class);
                                    startActivity(intent);
                                }
                            }); break;
                    }

                    dlg.setIcon(R.drawable.icon);
                    dlg.setView(dialogView);

                    dlg.show();
                }
            });

            return imageview;
         }
    }
}