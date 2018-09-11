package xyz.slashg.unpasito;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Test extends AppCompatActivity {
	@BindView(R.id.pasito)
	PasitoBar pasito;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_test);
		ButterKnife.bind(this);
		pasito.setData(1);
	}
}
