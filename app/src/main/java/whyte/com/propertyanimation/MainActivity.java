package whyte.com.propertyanimation;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView tvP_T;
    private Button btnP_T;
    private Button btnV_T;
    private TextView tvV_T;

    private TextView tvP_A;
    private Button btnP_A;
    private Button btnV_A;
    private TextView tvV_A;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initTranslate();

        initAlpha();

    }

    private void initAlpha() {
        tvP_A = (TextView) findViewById(R.id.tv_p_a);
        btnP_A = (Button) findViewById(R.id.btn_p_a);
        btnV_A = (Button) findViewById(R.id.btn_v_a);
        tvV_A = (TextView) findViewById(R.id.tv_v_a);
        btnP_A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator.ofFloat(tvP_A, "alpha", 0, 1).setDuration(3000).start();
            }
        });
        btnV_A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvV_A.startAnimation(AnimationUtils.loadAnimation(v.getContext(), R.anim.alpha));
            }
        });

    }

    private void initTranslate() {
        tvP_T = (TextView) findViewById(R.id.tv_p_t);
        btnP_T = (Button) findViewById(R.id.btn_p_t);
        btnV_T = (Button) findViewById(R.id.btn_v_t);
        tvV_T = (TextView) findViewById(R.id.tv_v_t);


        btnP_T.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //点击区域也发生了改变
                ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(tvP_T, "translationX", 0f, 200f);
                objectAnimator.setDuration(5000);
                objectAnimator.start();
            }
        });
        btnV_T.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //点击区域没有发生改变
                TranslateAnimation translateAnimation = (TranslateAnimation) AnimationUtils.loadAnimation(v.getContext(), R.anim.move_left_to_right);
                translateAnimation.setFillAfter(true);
                tvV_T.startAnimation(translateAnimation);
            }
        });
        tvP_T.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "property", Toast.LENGTH_SHORT).show();
            }
        });
        tvV_T.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "view", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
