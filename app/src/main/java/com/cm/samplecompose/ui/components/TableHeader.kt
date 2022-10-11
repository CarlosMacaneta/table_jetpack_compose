package com.cm.samplecompose.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import com.cm.samplecompose.util.Constants.ITEM_COLUMN_WEIGHT
import com.cm.samplecompose.util.Constants.QTD_COLUMN_WEIGHT
import com.cm.samplecompose.util.Constants.STOCK_COLUMN_WEIGHT

@Composable
fun TableHeader() {

    Row(Modifier.background(Color.Gray)) {
        TableCell(weight = ITEM_COLUMN_WEIGHT) {
            Text(
                text = "",
                softWrap = true,
                overflow = TextOverflow.Ellipsis,
                maxLines = 2
            )
        }
        TableCell(weight = STOCK_COLUMN_WEIGHT) {
            Text(
                text = "Column 2",
                softWrap = true,
                overflow = TextOverflow.Ellipsis,
                maxLines = 2
            )
        }
        TableCell(weight = QTD_COLUMN_WEIGHT) {
            Text(
                text = "Column 3",
                softWrap = true,
                overflow = TextOverflow.Ellipsis,
                maxLines = 2
            )
        }
    }
}