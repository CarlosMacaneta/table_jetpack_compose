package com.cm.samplecompose.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.cm.samplecompose.util.Constants.ITEM_COLUMN_WEIGHT
import com.cm.samplecompose.util.Constants.QTD_COLUMN_WEIGHT
import com.cm.samplecompose.util.Constants.STOCK_COLUMN_WEIGHT

@Composable
fun Table() {

    val tableData = (1..100).mapIndexed { index, item ->
        index to "Item $item"
    }

    val textFieldInitValues = List(tableData.size){ "" }
    val valueStateList = remember { mutableStateListOf<String>().apply {
        addAll(textFieldInitValues) }
    }


    LazyColumn(
        Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        item {
            TableHeader()
        }

        items(tableData) {
            val (index, text) = it
            Row(
                Modifier
                    .fillMaxWidth()
                    .height(IntrinsicSize.Min)) {
                TableCell(
                    weight = ITEM_COLUMN_WEIGHT
                ) {
                    Text(
                        text = if (index%2 == 0) "Lorem ipsum dolor sit amet, consectetur adipiscing elit."
                        else "Donec luctus aliquet sodales.",
                        softWrap = true,
                        modifier = Modifier.align(Alignment.CenterVertically)
                    )
                }
                TableCell(
                    weight = STOCK_COLUMN_WEIGHT
                ) {
                    Text(
                        text = text,
                        softWrap = true,
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 2,
                        textAlign = TextAlign.End,
                        modifier = Modifier.align(Alignment.CenterVertically)
                    )
                }
                TableCell(
                    weight = QTD_COLUMN_WEIGHT,
                    paddingAll = 0.dp
                ) {
                    TextField(
                        value = valueStateList[index],
                        onValueChange = { value -> valueStateList[index] = value },
                        modifier = Modifier
                            .fillMaxHeight()
                            .background(color = Color.White),
                        singleLine = true
                    )
                }
            }
        }
    }
}