package xyz.slashg.unpasito;

import android.content.Context;
import android.support.annotation.IntRange;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/**
 * @author SlashG
 * @created 11/09/18
 * @since <nextVersion/>
 */
public class PasitoBar extends FrameLayout {
	public static final int TYPE_DEFAULT = 298;
	public static final int TYPE_DONE = 299;
	public static final int TYPE_CURRENT = 300;
	StepView step1View;
	ConstraintLayout constraintLayout;
	StepView step2View;
	View layout;

	public PasitoBar(Context context) {
		super(context);
		init();
	}

	public PasitoBar(Context context, AttributeSet attributeSet) {
		super(context, attributeSet);
		init();
	}

	public void setData(@IntRange(from = 0, to = 1) int current) {
		switch (current) {
			case 1:
				// first step
				step2View.setData(TYPE_CURRENT);
				step1View.setData(TYPE_DONE);
				break;
			case 0:
			default:
				// first step
				step1View.setData(TYPE_CURRENT);
				step2View.setData(TYPE_DEFAULT);
				break;
		}
	}

	void getViewReferences() {
//		ButterKnife.bind(layout);

		step1View = findViewById(R.id.step_1);
		constraintLayout = findViewById(R.id.bar_cl_container);
		step2View = findViewById(R.id.step_2);
	}

	private void init() {
		layout = inflate(getContext(), R.layout.layout_bar, this);
		getViewReferences();
		layout.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

		new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
		step1View.setStepNumber(1);
		step2View.setStepNumber(2);
	}

}
