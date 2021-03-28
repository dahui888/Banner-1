package com.zj.banner.ui.indicator

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zj.banner.ui.PagerState
import com.zj.banner.ui.indicator.BannerGravity.BottomRight

/**
 * 数字指示器，显示数字的指示器
 * @param backgroundColor 数字指示器背景颜色
 * @param numberColor 数字的颜色
 *
 */
class NumberIndicator(
    var backgroundColor: Color = Color.Red,
    var numberColor: Color = Color.Green,
    var circleSize: Dp = 35.dp,
    var fontSize: TextUnit = 16.sp,
) : Indicator() {

    init {
        setGravity(BottomRight)
    }

    @Composable
    override fun DrawIndicator(pagerState: PagerState) {
        val alignment: Alignment = when (getGravity()) {
            BannerGravity.BottomCenter -> {
                Alignment.BottomCenter
            }
            BannerGravity.BottomLeft -> {
                Alignment.BottomStart
            }
            BottomRight -> {
                Alignment.BottomEnd
            }
            else -> Alignment.BottomEnd
        }
        Box(modifier = Modifier.fillMaxSize().padding(10.dp), contentAlignment = alignment) {
            Box(
                modifier = Modifier.size(circleSize).clip(CircleShape)
                    .background(color = backgroundColor),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    "${pagerState.currentPage + 1}/${pagerState.maxPage + 1}",
                    color = numberColor,
                    fontSize = fontSize
                )
            }
        }

        // 这里原本也想使用 Canvas 画一下的，但想了想有的朋友可能不喜欢画，所以就使用 Box 进行布局了，
        // 看大家需要了，哪种写法都是可以的。

//            Canvas(modifier = Modifier.fillMaxSize()) {
//                val canvasWidth = size.width
//                val canvasHeight = size.height
//                val start = when (gravity) {
//                    BannerGravity.Center -> {
//                        val width = canvasWidth - pagerState.maxPage * 50
//                        width / 2
//                    }
//                    BannerGravity.Left -> {
//                        100f
//                    }
//                    Right -> {
//                        canvasWidth - pagerState.maxPage * 50f - 100f
//
//                    }
//                    else -> 100f
//                }
//                drawCircle(
//                    backgroundColor,
//                    50f,
//                    center = Offset(start, canvasHeight)
//                )
//                drawIntoCanvas { canvas ->
//                canvas.nativeCanvas.drawText(
//                    text,
//                    -rectText.width().toFloat() - 42f,
//                    rectText.height().toFloat() / 2,
//                    text_paint
//                )
//    }
//            }

    }

}