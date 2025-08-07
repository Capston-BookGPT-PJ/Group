package com.example.meltingbooks;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.core.content.ContextCompat;

public class SearchActivity extends Activity {
    private ImageButton searchIcon;
    private EditText searchInput;

    // TODO: 여기에 실제 검색 로직 추가 (도서, 감상문, 해시태그, 사용자 등 필터링 등)
    private void performSearch(String keyword) {
        Toast.makeText(this, "검색어: " + keyword, Toast.LENGTH_SHORT).show();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        // 상태바 색상 설정
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.white));
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            View decor = getWindow().getDecorView();
            decor.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }

        // UI 연결
        searchInput = findViewById(R.id.searchInput); //검색어 입력
        searchIcon = findViewById(R.id.searchIcon); //검색 수행
        View root = findViewById(R.id.activity_search);


        // 키보드 자동 표시
        searchInput.requestFocus();
        InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        imm.showSoftInput(searchInput, InputMethodManager.SHOW_IMPLICIT);

        // 검색 실행
        searchIcon.setOnClickListener(v -> {
            String keyword = searchInput.getText().toString();
            if (!keyword.isEmpty()) {
                performSearch(keyword);
            } else {
                Toast.makeText(this, "검색어를 입력하세요", Toast.LENGTH_SHORT).show();
            }
        });
        root.setOnClickListener(v -> {
            finish();
        });
    }
}
