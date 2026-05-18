package com.example.catalogo_videojuegos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.Alignment
import com.example.catalogo_videojuegos.ui.theme.Catalogo_videojuegosTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val gameList = listOf(
            Game("Hollow Knight", "PC/Consolas", R.drawable.hk),
            Game("Nine Sols", "PC/Consolas", R.drawable.ns),
            Game("Buena Pizza, Gran Pizza", "Móvil", R.drawable.bgp),
            Game("Minecraft", "Multiplataforma", R.drawable.mnft),
            Game("Buen Café, Gran Café", "Móvil", R.drawable.bgc),
            Game("Dancing Line", "Móvil", R.drawable.dl),
            Game("Piano Tiles", "Móvil", R.drawable.pt),
            Game("Stardew Valley", "Multiplataforma", R.drawable.sv),
            Game("Celeste", "PC/Consolas", R.drawable.celeste),
            Game("Among Us", "Multiplataforma", R.drawable.amongus)
        )

        enableEdgeToEdge()
        setContent {
            Catalogo_videojuegosTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    GameListScreen(gameList, Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun GameListScreen(games: List<Game>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier.padding(16.dp)) {
        items(games) { game ->
            GameCard(game)
        }
    }
}

@Composable
fun GameCard(game: Game) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        shape = MaterialTheme.shapes.medium,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        )
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // 👇 Imagen del juego
            Image(
                painter = painterResource(id = game.imagen),
                contentDescription = game.titulo,
                modifier = Modifier
                    .size(64.dp)
                    .clip(RoundedCornerShape(8.dp))
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column {
                Text(text = game.titulo, style = MaterialTheme.typography.titleLarge)
                Text(text = "Plataforma: ${game.plataforma}", style = MaterialTheme.typography.bodyMedium)
            }
        }
    }
}
