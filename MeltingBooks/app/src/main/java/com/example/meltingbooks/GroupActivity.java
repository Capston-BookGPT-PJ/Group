package com.example.meltingbooks;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;








public class GroupActivity extends AppCompatActivity {

    private LinearLayout noticeBox;
    private EditText noticeEditText, recommendBookEditText;
    private ImageButton groupWriteButton;
    private ImageView groupArrow;
    private RecyclerView groupRecyclerView;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group);

        // 뷰 연결
        noticeBox = findViewById(R.id.noticeBox);
        noticeEditText = findViewById(R.id.noticeEditText);
        recommendBookEditText = findViewById(R.id.recommendBookEditText);
        groupArrow = findViewById(R.id.group_arrow);

        //그룹 게시글 작성 버튼
        groupWriteButton = findViewById(R.id.groupWrite);

        //그룹 게시글
        groupRecyclerView = findViewById(R.id.groupRecyclerView);
        groupRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // 상태바 색상 조정
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.white));
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            View decor = getWindow().getDecorView();
            decor.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }

        // 공지 작성
        noticeBox.setOnClickListener(v -> {
            String notice = noticeEditText.getText().toString();
            String book = recommendBookEditText.getText().toString();
            Toast.makeText(this, "공지: " + notice + "\n추천도서: " + book, Toast.LENGTH_SHORT).show();
            // TODO: 서버 저장
        });

        // 감상문 작성 버튼 → UploadAudio
        groupWriteButton.setOnClickListener(v -> {
            Intent intent = new Intent(GroupActivity.this, BrowseActivity.class);
            startActivity(intent);
        });

        // 공통 독서 기록 추가 페이지(미정)
        groupArrow.setOnClickListener(v -> {
            Intent intent = new Intent(GroupActivity.this, GroupAddGoal.class);
            startActivity(intent);
        });


        // 예시 데이터
        List<FeedItem> groupPosts = new ArrayList<>();
        groupPosts.add(new FeedItem("홍길동", "그룹 감상문 예시입니다.", "2시간 전", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSFTmLS_fo74SyNTs3iF08HpcAntn2lBTmwVg&s"));
        groupPosts.add(new FeedItem("이몽룡", "추천 도서 감상입니다.", "1일 전", null));

        GroupAdapter groupAdapter = new GroupAdapter(this, groupPosts);
        groupRecyclerView.setAdapter(groupAdapter);
    }



}
