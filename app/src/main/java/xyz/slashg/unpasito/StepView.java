package xyz.slashg.unpasito;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import butterknife.BindView;

/**
 * @author SlashG
 * @created 11/09/18
 * @since <nextVersion/>
 */
public class StepView extends FrameLayout {
	private static final int DEFAULT_INDEX = 0;
	private static final int CURRENT_INDEX = 1;
	private static final int DONE_INDEX = 2;
	View layout;
	@BindView(R.id.flipper)
	ViewFlipper flipper;
	@BindView(R.id.view_done)
	ImageView viewDone;
	@BindView(R.id.view_default)
	View viewDefault;
	@BindView(R.id.view_current)
	AppCompatTextView viewCurrent;

	public StepView(Context context) {
		super(context);
		init();
	}


	public StepView(Context context, AttributeSet attributeSet) {
		super(context, attributeSet);
		init();
	}


	public void setData(int type) {
		int childIndex;
		switch (type) {
			case PasitoBar.TYPE_CURRENT:
				childIndex = CURRENT_INDEX;
				break;
			case PasitoBar.TYPE_DONE:
				childIndex = DONE_INDEX;
				break;
			case PasitoBar.TYPE_DEFAULT:
			default:
				childIndex = DEFAULT_INDEX;
		}
		flipper.setDisplayedChild(childIndex);
	}

	public void setStepNumber(int stepNumber) {
		viewCurrent.setText(String.valueOf(stepNumber));
	}

	void getViewReferences() {
//		ButterKnife.bind(layout);

		flipper = findViewById(R.id.flipper);
		viewDone = findViewById(R.id.view_done);
		viewDefault = findViewById(R.id.view_default);
		viewCurrent = findViewById(R.id.view_current);
	}

	private void init() {
		layout = inflate(getContext(), R.layout.layout_step, this);
		getViewReferences();
		setLayoutParams(new ConstraintLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
	}
}
