package com.example.docdanhba;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.docdanhba.model.Contact;

import java.util.ArrayList;

public class DanhBa extends AppCompatActivity {

    private  static final  int REQUEST_CODE_ASK_PERMISSSIONS =1001;

    ListView lvDanhBa;
    ArrayList<Contact> dsDanhBa;
    ArrayAdapter<Contact> adapterDanhBa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_ba);
        addControls();
        showAllContactFromDevice();
    }
    private void showAllContactFromDevice(){
        // Thong qua contactscontract để lấy contact trong điện thoại
        Uri uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
        //Trả về 1 cursor - quản lý dữ liệu contact trong điện thoại
        Cursor cursor = getContentResolver().query(uri,null,null,null,null);
        dsDanhBa.clear();

        while (cursor.moveToNext()){
            //Lấy thông tin trong danh bạ
            String tenCotName = ContactsContract.Contacts.DISPLAY_NAME;
            //Lấy thông tin số điện thoại trong danh bạ
            String tenCotPhone = ContactsContract.CommonDataKinds.Phone.NUMBER;
            //Lấy vị trí trong cột dữ liệu
            int viTriCotName = cursor.getColumnIndex(tenCotName);
            int viTroCotPhone = cursor.getColumnIndex(tenCotPhone);
            //Lấu dữ liệu trong cột ra
            String name = cursor.getString(viTriCotName);
            String phone = cursor.getString(viTroCotPhone);
            //Đưa vào mảng
            Contact contact = new Contact(name,phone);
            dsDanhBa.add(contact);
            adapterDanhBa.notifyDataSetChanged();
        }
    }

    private void addControls(){
        lvDanhBa = findViewById(R.id.lvDanhBa);
        dsDanhBa = new ArrayList<>();
        adapterDanhBa = new ArrayAdapter<>(
                DanhBa.this, android.R.layout.simple_list_item_1,dsDanhBa
        );
        lvDanhBa.setAdapter(adapterDanhBa);
    }
}