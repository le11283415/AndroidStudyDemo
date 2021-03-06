package com.cheng.animationstudy.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.cheng.animationstudy.R;
import com.cheng.animationstudy.customview.baiduread.ImportMenuView;
import com.cheng.animationstudy.customview.baiduread.RippleLayout;
import com.cheng.utils.ViewFinder;

/**
 * 模仿百度阅读气泡
 */
public class ImitateBaiduReadBubbleActivity extends AppCompatActivity {

    public static ImageButton mAddIBtn;
    public static RippleLayout mRippleLayout;
    private ImportMenuView mImportMenuView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imitatebaidureadbubble);

        initView();
    }

    private void initView() {
        mAddIBtn = ViewFinder.findViewById(this, R.id.ibtn_add);
        mRippleLayout = ViewFinder.findViewById(this, R.id.ripplelayout);
        mImportMenuView = ViewFinder.findViewById(this, R.id.importmenu);

        mImportMenuView.setEnabled(false);
        mRippleLayout.setRippleFinishListener(new RippleLayout.RippleFinishListener() {
            @Override
            public void rippleFinish(int id) {
                if (id == R.id.ripplelayout) {
                    mImportMenuView.setVisibility(View.VISIBLE);
                    mImportMenuView.setEnabled(true);
                    mImportMenuView.setFocusable(true);
                    mImportMenuView.closeVisiableAnimation();
                    mImportMenuView.animation(ImitateBaiduReadBubbleActivity.this);
                    mImportMenuView.bringToFront();
                    mRippleLayout.setVisibility(View.GONE);
                }
            }
        });
    }

}
