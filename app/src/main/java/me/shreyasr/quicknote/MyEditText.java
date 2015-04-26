package me.shreyasr.quicknote;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.EditText;

public class MyEditText extends EditText {

    private static Paint linePaint;
    private Rect bounds = new Rect();

    public MyEditText(Context context, AttributeSet attributes) {
        super(context, attributes);
        linePaint = new Paint();
        linePaint.setColor(getResources().getColor(R.color.lines));
        linePaint.setStyle(Paint.Style.STROKE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        linePaint.setAlpha((int) (this.getAlpha()*255));
        Log.d("Drawing", "Drawing " + this.getAlpha());
        int firstLineY = getLineBounds(0, bounds);
        int lineHeight = getLineHeight();
        int totalLines = Math.max(getLineCount(), getHeight() / lineHeight);

        for (int i = 0; i < totalLines; i++) {
            int lineY = firstLineY + i * lineHeight;
            canvas.drawLine(bounds.left, lineY, bounds.right, lineY, linePaint);
        }
        super.onDraw(canvas);
    }
}