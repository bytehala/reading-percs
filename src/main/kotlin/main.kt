import androidx.compose.desktop.Window
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp

fun main() = Window("ReadingPercs", IntSize(300, 200)) {
    var text by remember { mutableStateOf("") }
    var currentPage by remember { mutableStateOf(0)}
    var totalPages by remember { mutableStateOf(248) }
    var progress by remember { mutableStateOf(0.1f) }

    MaterialTheme {
        Column(Modifier.padding(5.dp), Arrangement.spacedBy(5.dp)){


            Row(Modifier.fillMaxWidth(), Arrangement.Center) {
                Column(Modifier.padding(0.dp, 5.dp), Arrangement.spacedBy(5.dp)) {
                    Button(onClick = {
                        currentPage += 1;
                    }) {
                        Text("+1")
                    }
                    Button(onClick = {
                        currentPage -= 1;
                    }) {
                        Text("-1")
                    }
                }
                Column(Modifier.padding(5.dp), Arrangement.spacedBy(5.dp)) {
                    Button(onClick = {
                        currentPage += 5;
                    }) {
                        Text("+5")
                    }
                    Button(onClick = {
                        currentPage -= 5;
                    }) {
                        Text("-5")
                    }
                }
                Column(Modifier.padding(0.dp, 5.dp), Arrangement.spacedBy(5.dp)) {
                    Button(onClick = {
                        currentPage += 10;
                    }) {
                        Text("+10")
                    }
                    Button(onClick = {
                        currentPage -= 10;
                    }) {
                        Text("-10")
                    }
                }
            }


            if (currentPage > totalPages) currentPage = totalPages
            else if (currentPage < 0) currentPage = 0
            LinearProgressIndicator(progress = currentPage.toFloat() / totalPages, Modifier.fillMaxWidth())
            Text(currentPage.toString().plus(" / ").plus(totalPages), Modifier.fillMaxWidth(), textAlign = TextAlign.Center)
            Text(( String.format("%.2f", 100 * currentPage.toFloat() / totalPages)).plus("%"), Modifier.fillMaxWidth(), textAlign = TextAlign.Center)
        }
    }
}