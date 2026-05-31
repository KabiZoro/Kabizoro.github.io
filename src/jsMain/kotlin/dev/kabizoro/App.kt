package dev.kabizoro

import androidx.compose.runtime.*
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*
import org.jetbrains.compose.web.renderComposable

fun main() {
    renderComposable(rootElementId = "root") {
        Style(AppStyles)
        PortfolioApp()
    }
}

@Composable
fun PortfolioApp() {
    Div({ classes("app") }) {
        NavBar()
        Div({ classes("wrap") }) {
            Hero()
            AboutSection()
            TechStackSection()
            ProjectsSection()
            CodeSection()
            StatsSection()
            Footer()
        }
    }
}

// ─── NAV ────────────────────────────────────────────────────────────────────

@Composable
fun NavBar() {
    Nav({ classes("nav") }) {
        Div({ classes("nav-inner") }) {
            A(href = "#", { classes("nav-logo") }) {
                Span({ classes("nav-logo-comment") }) { Text("//") }
                Text(" KabiZoro")
            }
            Ul({ classes("nav-links") }) {
                listOf("about", "stack", "projects", "code", "stats").forEach { section ->
                    Li {
                        A(href = "#$section") { Text(section) }
                    }
                }
            }
            Div({ classes("nav-dot") }) {}
        }
    }
}

// ─── HERO ────────────────────────────────────────────────────────────────────

@Composable
fun Hero() {
    Div({ classes("hero") }) {
        Div({ classes("hero-bg-glow") }) {}
        Div({ classes("cursor-line") }) { Text("// kabizoro.github.io ▸ android_dev.kt") }
        Div({ classes("name") }) {
            Text("Hey, I'm ")
            Span({ classes("name-highlight") }) { Text("Harish Kabilan") }
            Text(" 👋")
        }
        Div({ classes("role") }) {
            Text("Native Android Developer · ")
            Em({ classes("role-kotlin") }) { Text("Kotlin") }
            Text(" · Clean Arch · Real Apps")
        }
        Div({ classes("socials") }) {
            SocialLink("https://www.linkedin.com/in/harish-kabilan-20hk", "LinkedIn", "💼")
            SocialLink("https://github.com/KabiZoro", "GitHub", "🐙")
            SocialLink("mailto:kabi.rengoku2004@gmail.com", "Gmail", "📧")
            SocialLink("https://medium.com/@kabi20", "Medium", "✍️")
        }
        Div({ classes("pills") }) {
            listOf(
                "Focus · Native Android",
                "Lang · Kotlin",
                "Exp · 2 Years",
                "Open · Collaborate"
            ).forEach { Span({ classes("pill") }) { Text(it) } }
        }
    }
}

@Composable
fun SocialLink(href: String, label: String, emoji: String) {
    A(href = href, { classes("soc") }) {
        Span { Text("$emoji ") }
        Text(label)
    }
}

// ─── ABOUT ───────────────────────────────────────────────────────────────────

@Composable
fun AboutSection() {
    Section({ classes("section"); id("about") }) {
        SectionLabel("About me")
        Ul({ classes("about-list") }) {
            AboutItem("📱", "Native Android Developer", " with 2 years of hands-on experience in Kotlin")
            AboutItem("💼", "Currently at a company", " — shipping production apps for 4+ months")
            AboutItem("🔵", "Love working close to hardware", " — Bluetooth, sensors, local-first architecture")
            AboutItem("🧠", "Believer in Clean Architecture", ", privacy-first design, and meaningful UX")
            AboutItem("🌱", "Currently diving deeper into Jetpack Compose", " and Kotlin Coroutines & Flow")
            AboutItem("⚡", "Fun fact:", " built a chat app that intentionally stores nothing — by design")
        }
    }
}

@Composable
fun AboutItem(emoji: String, bold: String, rest: String) {
    Li({ classes("about-item") }) {
        Span({ classes("dot") }) { Text("▸") }
        Span {
            Text("$emoji ")
            B { Text(bold) }
            Text(rest)
        }
    }
}

// ─── TECH STACK ──────────────────────────────────────────────────────────────

@Composable
fun TechStackSection() {
    Section({ classes("section"); id("stack") }) {
        SectionLabel("Tech stack")

        StackGroup("Languages") {
            Chip("Kotlin", ChipStyle.Green)
            Chip("Java", ChipStyle.Default)
        }
        StackGroup("Android & Tools") {
            listOf("Android Studio" to ChipStyle.Green, "Firebase" to ChipStyle.Default,
                "Gradle" to ChipStyle.Default, "Git" to ChipStyle.Default,
                "GitHub" to ChipStyle.Default, "Postman" to ChipStyle.Default,
                "Figma" to ChipStyle.Default
            ).forEach { (name, style) -> Chip(name, style) }
        }
        StackGroup("Libraries & Patterns") {
            listOf(
                "MVI / MVVM" to ChipStyle.Green, "Retrofit2" to ChipStyle.Purple,
                "Koin" to ChipStyle.Purple, "Hilt" to ChipStyle.Purple,
                "Room" to ChipStyle.Green, "Coroutines + Flow" to ChipStyle.Green,
                "ViewModel" to ChipStyle.Default, "Navigation" to ChipStyle.Default,
                "DataStore" to ChipStyle.Default
            ).forEach { (name, style) -> Chip(name, style) }
        }
    }
}

enum class ChipStyle { Default, Green, Purple }

@Composable
fun StackGroup(label: String, content: @Composable () -> Unit) {
    Div({ classes("stack-group") }) {
        Div({ classes("stack-label") }) { Text(label) }
        Div({ classes("stack-row") }) { content() }
    }
}

@Composable
fun Chip(text: String, style: ChipStyle = ChipStyle.Default) {
    val cls = when (style) {
        ChipStyle.Green -> "chip chip-green"
        ChipStyle.Purple -> "chip chip-purple"
        ChipStyle.Default -> "chip"
    }
    Span({ classes(*cls.split(" ").toTypedArray()) }) { Text(text) }
}

// ─── PROJECTS ────────────────────────────────────────────────────────────────

data class Project(
    val icon: String,
    val title: String,
    val desc: String,
    val badges: List<Pair<String, String>>, // label to badge class
    val points: List<String>
)

val projects = listOf(
    Project(
        icon = "📡",
        title = "Bluetooth Chat App",
        desc = "Peer-to-peer chat over Bluetooth — zero data stored. Messages exist only during the session; once connection drops, everything is gone. Privacy by design, not by policy.",
        badges = listOf(
            "Kotlin" to "badge-g",
            "Bluetooth Classic + BLE" to "badge",
            "MVI" to "badge-p",
            "Zero Persistence" to "badge-r"
        ),
        points = listOf(
            "Real-time messaging over Bluetooth without internet",
            "Ephemeral by design — no logs, no SQLite, no SharedPrefs",
            "Works completely offline — no server, no cloud",
            "Handles connection lifecycle, pairing, and device discovery"
        )
    ),
    Project(
        icon = "🌤️",
        title = "Weather App — Retrofit + Koin",
        desc = "A clean weather app built to practice production-grade networking and dependency injection patterns using Retrofit and Koin.",
        badges = listOf(
            "Kotlin" to "badge-g",
            "Retrofit2" to "badge-p",
            "Koin" to "badge-p",
            "MVI" to "badge-p"
        ),
        points = listOf(
            "REST API calls via Retrofit2 with clean repository pattern",
            "Dependency injection with Koin — no boilerplate, lightweight",
            "ViewModel + LiveData for lifecycle-aware UI state",
            "Location-based weather with real API integration"
        )
    ),
    Project(
        icon = "🎙️",
        title = "Echo Journal — Voice Notes with Moods",
        desc = "A daily journal app where you record voice notes and tag them with custom moods. Your journal entry is your voice — categorized by the emotion behind it.",
        badges = listOf(
            "Kotlin" to "badge-g",
            "Room" to "badge-g",
            "MVI" to "badge-p",
            "MediaRecorder / ExoPlayer" to "badge"
        ),
        points = listOf(
            "Voice recording as the primary input — no typing required",
            "Custom mood tagging system tied to each journal entry",
            "Daily journal timeline with mood history",
            "All data stored locally with Room — stays on device"
        )
    )
)

@Composable
fun ProjectsSection() {
    Section({ classes("section"); id("projects") }) {
        SectionLabel("Projects")
        Div({ classes("projects") }) {
            projects.forEach { ProjectCard(it) }
        }
    }
}

@Composable
fun ProjectCard(project: Project) {
    Div({ classes("proj") }) {
        Div({ classes("proj-title") }) {
            Text("${project.icon}  ${project.title}")
        }
        Div({ classes("proj-desc") }) { Text(project.desc) }
        Div({ classes("proj-badges") }) {
            project.badges.forEach { (label, cls) ->
                Span({ classes("badge", cls) }) { Text(label) }
            }
        }
        Ul({ classes("proj-points") }) {
            project.points.forEach { point ->
                Li({ classes("proj-point") }) { Text(point) }
            }
        }
    }
}

// ─── CODE ─────────────────────────────────────────────────────────────────────

@Composable
fun CodeSection() {
    Section({ classes("section"); id("code") }) {
        SectionLabel("How I think about code")
        Div({ classes("code-block") }) {
            Pre {
                // Rendered as styled spans via innerHTML workaround using raw HTML
                Code {
                    // Purple keywords
                    KW("val"); NM(" KabiZoro"); Text(" = "); FN("AndroidDeveloper"); Text("(\n")
                    NM("  languages"); Text("    = "); FN("listOf"); Text("("); STR("\"Kotlin\""); Text(", "); STR("\"Java\""); Text("),\n")
                    NM("  architecture"); Text(" = "); FN("listOf"); Text("("); STR("\"MVI\""); Text(", "); STR("\"MVVM\""); Text(", "); STR("\"Clean Architecture\""); Text("),\n")
                    NM("  jetpack"); Text("      = "); FN("listOf"); Text("("); STR("\"ViewModel\""); Text(", "); STR("\"LiveData\""); Text(", "); STR("\"Room\""); Text(",\n")
                    Text("                        "); STR("\"Navigation\""); Text(", "); STR("\"WorkManager\""); Text(", "); STR("\"DataStore\""); Text("),\n")
                    NM("  networking"); Text("   = "); FN("listOf"); Text("("); STR("\"Retrofit2\""); Text(", "); STR("\"OkHttp\""); Text(", "); STR("\"Ktor\""); Text(", "); STR("\"Gson\""); Text("),\n")
                    NM("  di"); Text("           = "); FN("listOf"); Text("("); STR("\"Koin\""); Text(", "); STR("\"Hilt\""); Text("),\n")
                    NM("  async"); Text("        = "); FN("listOf"); Text("("); STR("\"Coroutines\""); Text(", "); STR("\"Flow\""); Text("),\n")
                    NM("  hardware"); Text("     = "); FN("listOf"); Text("("); STR("\"Bluetooth Classic\""); Text(", "); STR("\"BLE\""); Text(", "); STR("\"MediaRecorder\""); Text("),\n")
                    NM("  principles"); Text("   = "); FN("listOf"); Text("("); STR("\"Privacy-first\""); Text(", "); STR("\"Offline-first\""); Text(",\n")
                    Text("                        "); STR("\"Zero unnecessary storage\""); Text(")\n)")
                }
            }
        }
    }
}

@Composable fun KW(text: String) = Span({ classes("kw") }) { Text(text) }
@Composable fun NM(text: String) = Span({ classes("nm") }) { Text(text) }
@Composable fun FN(text: String) = Span({ classes("fn") }) { Text(text) }
@Composable fun STR(text: String) = Span({ classes("str") }) { Text(text) }

// ─── STATS ────────────────────────────────────────────────────────────────────

@Composable
fun StatsSection() {
    Section({ classes("section"); id("stats") }) {
        SectionLabel("GitHub stats")
        Div({ classes("stats-grid") }) {
            Div({ classes("stat-card") }) {
                Img(
                    src = "https://github-readme-stats.vercel.app/api?username=KabiZoro&show_icons=true&hide_border=true&count_private=true&bg_color=232624&title_color=00F15E&icon_color=00F15E&text_color=87938C",
                    alt = "GitHub Stats"
                ) { classes("stat-img") }
            }
            Div({ classes("stat-card") }) {
                Img(
                    src = "https://streak-stats.demolab.com/?user=KabiZoro&hide_border=true&background=232624&ring=00F15E&fire=00F15E&currStreakLabel=00F15E&sideLabels=87938C&dates=87938C&sideNums=FAFAFA&currStreakNum=FAFAFA",
                    alt = "Streak Stats"
                ) { classes("stat-img") }
            }
        }
        Div({ classes("stats-langs") }) {
            Img(
                src = "https://github-readme-stats.vercel.app/api/top-langs/?username=KabiZoro&layout=compact&hide_border=true&bg_color=232624&title_color=00F15E&text_color=87938C&langs_count=6",
                alt = "Top Languages"
            ) { classes("stat-img") }
        }
    }
}

// ─── FOOTER ───────────────────────────────────────────────────────────────────

@Composable
fun Footer() {
    Footer({ classes("footer") }) {
        Div({ classes("footer-views") }) {
            Text("Profile Views · ")
            Span({ classes("footer-username") }) { Text("KabiZoro") }
        }
        Div({ classes("footer-quote") }) {
            Text("\"The best privacy feature is the one users never have to think about.\"")
        }
        Div({ classes("footer-copy") }) {
            Text("© 2025 Harish Kabilan · kabizoro.github.io")
        }
    }
}

// ─── SHARED ───────────────────────────────────────────────────────────────────

@Composable
fun SectionLabel(text: String) {
    Div({ classes("sec-label") }) { Text(text) }
}