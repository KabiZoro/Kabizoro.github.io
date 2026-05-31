package dev.kabizoro

import org.jetbrains.compose.web.css.*

object AppStyles : StyleSheet() {

    // ── Variables ────────────────────────────────────────────────────────────
    val green = "#00F15E"
    val green30 = "rgba(0,241,94,0.3)"
    val green10 = "rgba(0,241,94,0.1)"
    val green05 = "rgba(0,241,94,0.05)"
    val bg = "#080707"
    val surface = "#232624"
    val muted = "#87938C"
    val muted40 = "rgba(135,147,140,0.4)"
    val white = "#FAFAFA"
    val red = "#BB3D3D"
    val red05 = "rgba(187,61,61,0.05)"
    val purple = "#7F52FF"

    init {
        // ── Reset & Base ────────────────────────────────────────────────────
        "*, *::before, *::after" style {
            property("box-sizing", "border-box")
            margin(0.px)
            padding(0.px)
        }
        "html" style {
            property("scroll-behavior", "smooth")
        }
        "body" style {
            background(bg)
            color(white)
            fontFamily("'Space Grotesk'", "sans-serif")
            property("overflow-x", "hidden")
            property("min-height", "100vh")
        }
        "a" style { property("text-decoration", "none") }

        // Scrollbar
        "::-webkit-scrollbar" style { width(4.px) }
        "::-webkit-scrollbar-track" style { background(bg) }
        "::-webkit-scrollbar-thumb" style {
            background(green30)
            borderRadius(2.px)
        }

        // ── App & Wrap ───────────────────────────────────────────────────────
        ".app" style { minHeight(100.vh) }

        ".wrap" style {
            maxWidth(780.px)
            margin(0.px, autoLength)
            padding(80.px, 24.px, 48.px)
        }

        // ── Nav ──────────────────────────────────────────────────────────────
        ".nav" style {
            position(Position.Fixed)
            top(0.px); left(0.px); right(0.px)
            property("z-index", "100")
            background("rgba(8,7,7,0.88)")
            property("backdrop-filter", "blur(12px)")
            borderBottom(1.px, LineStyle.Solid, "rgba(0,241,94,0.08)")
            padding(0.px, 24.px)
        }
        ".nav-inner" style {
            maxWidth(780.px)
            margin(0.px, autoLength)
            display(DisplayStyle.Flex)
            alignItems(AlignItems.Center)
            property("justify-content", "space-between")
            height(52.px)
        }
        ".nav-logo" style {
            fontFamily("'JetBrains Mono'", "monospace")
            fontSize(13.px)
            color(green)
            property("letter-spacing", "0.06em")
        }
        ".nav-logo-comment" style { color(muted) }
        ".nav-links" style {
            display(DisplayStyle.Flex)
            gap(20.px)
            property("list-style", "none")
        }
        ".nav-links a" style {
            fontFamily("'JetBrains Mono'", "monospace")
            fontSize(11.px)
            color(muted)
            property("letter-spacing", "0.08em")
            property("transition", "color 0.15s")
        }
        ".nav-links a:hover" style { color(green) }
        ".nav-dot" style {
            width(6.px); height(6.px)
            borderRadius(50.percent)
            background(green)
            property("animation", "pulse 2s infinite")
        }
        "@keyframes pulse" style {}

        // ── Hero ─────────────────────────────────────────────────────────────
        ".hero" style {
            property("text-align", "center")
            padding(56.px, 0.px, 36.px)
            borderBottom(1.px, LineStyle.Solid, "rgba(0,241,94,0.12)")
            position(Position.Relative)
        }
        ".hero-bg-glow" style {
            position(Position.Absolute)
            top(0.px)
            left(50.percent)
            property("transform", "translateX(-50%)")
            width(320.px); height(320.px)
            background("radial-gradient(circle,rgba(0,241,94,0.07) 0%,transparent 70%)")
            property("pointer-events", "none")
        }
        ".cursor-line" style {
            fontFamily("'JetBrains Mono'", "monospace")
            fontSize(11.px)
            color(green)
            property("letter-spacing", "0.1em")
            marginBottom(18.px)
            opacity(0.7)
        }
        ".name" style {
            fontSize(42.px)
            fontWeight(600)
            color(white)
            property("letter-spacing", "-1px")
            property("line-height", "1.1")
            marginBottom(6.px)
        }
        ".name-highlight" style { color(green) }
        ".role" style {
            fontFamily("'JetBrains Mono'", "monospace")
            fontSize(14.px)
            color(muted)
            property("letter-spacing", "0.04em")
            marginTop(8.px)
        }
        ".role-kotlin" style {
            color(purple)
            fontStyle("normal")
        }

        // ── Socials ──────────────────────────────────────────────────────────
        ".socials" style {
            display(DisplayStyle.Flex)
            property("justify-content", "center")
            gap(8.px)
            property("flex-wrap", "wrap")
            marginTop(24.px)
        }
        ".soc" style {
            display(DisplayStyle.InlineFlex)
            alignItems(AlignItems.Center)
            gap(6.px)
            padding(7.px, 16.px)
            border(1.px, LineStyle.Solid, "rgba(0,241,94,0.25)")
            borderRadius(6.px)
            fontSize(12.px)
            fontWeight(500)
            color(muted)
            background(green05)
            property("transition", "all 0.2s")
        }
        ".soc:hover" style {
            borderColor(green)
            color(green)
            background(green10)
            property("transform", "translateY(-1px)")
        }

        // ── Pills ────────────────────────────────────────────────────────────
        ".pills" style {
            display(DisplayStyle.Flex)
            property("justify-content", "center")
            gap(6.px)
            property("flex-wrap", "wrap")
            marginTop(16.px)
        }
        ".pill" style {
            fontFamily("'JetBrains Mono'", "monospace")
            fontSize(10.px)
            padding(3.px, 12.px)
            borderRadius(99.px)
            border(1.px, LineStyle.Solid, "rgba(0,241,94,0.2)")
            color(green)
            background(green05)
            property("letter-spacing", "0.06em")
        }

        // ── Section ──────────────────────────────────────────────────────────
        ".section" style {
            marginTop(32.px)
            property("animation", "fadeUp 0.4s ease both")
        }
        ".sec-label" style {
            fontFamily("'JetBrains Mono'", "monospace")
            fontSize(10.px)
            color(green)
            property("letter-spacing", "0.14em")
            property("text-transform", "uppercase")
            marginBottom(14.px)
            display(DisplayStyle.Flex)
            alignItems(AlignItems.Center)
            gap(10.px)
        }
        ".sec-label::after" style {
            property("content", "''")
            property("flex", "1")
            height(1.px)
            background("rgba(0,241,94,0.12)")
        }

        // ── About ────────────────────────────────────────────────────────────
        ".about-list" style { property("list-style", "none") }
        ".about-item" style {
            fontSize(14.px)
            color(muted)
            padding(8.px, 0.px)
            display(DisplayStyle.Flex)
            gap(12.px)
            property("line-height", "1.6")
            borderBottom(1.px, LineStyle.Solid, "rgba(135,147,140,0.08)")
        }
        ".about-item:last-child" style { property("border-bottom", "none") }
        ".about-item strong, .about-item b" style {
            color(white)
            fontWeight(500)
        }
        ".dot" style {
            color(green)
            property("flex-shrink", "0")
            fontFamily("'JetBrains Mono'", "monospace")
            marginTop(1.px)
        }

        // ── Stack ────────────────────────────────────────────────────────────
        ".stack-group" style { marginBottom(14.px) }
        ".stack-label" style {
            fontSize(10.px)
            color(muted)
            fontFamily("'JetBrains Mono'", "monospace")
            marginBottom(8.px)
            property("letter-spacing", "0.06em")
        }
        ".stack-row" style {
            display(DisplayStyle.Flex)
            property("flex-wrap", "wrap")
            gap(6.px)
        }
        ".chip" style {
            fontFamily("'JetBrains Mono'", "monospace")
            fontSize(11.px)
            padding(5.px, 11.px)
            borderRadius(5.px)
            background(surface)
            color(muted)
            border(1.px, LineStyle.Solid, "rgba(135,147,140,0.18)")
            property("transition", "all 0.15s")
            property("cursor", "default")
        }
        ".chip:hover" style {
            borderColor("rgba(135,147,140,0.4)")
            color(white)
        }
        ".chip-green" style {
            color(green)
            borderColor("rgba(0,241,94,0.28)")
            background(green05)
        }
        ".chip-green:hover" style { background(green10) }
        ".chip-purple" style {
            color(purple)
            borderColor("rgba(127,82,255,0.28)")
            background("rgba(127,82,255,0.05)")
        }
        ".chip-purple:hover" style { background("rgba(127,82,255,0.1)") }

        // ── Projects ─────────────────────────────────────────────────────────
        ".projects" style {
            display(DisplayStyle.Flex)
            flexDirection(FlexDirection.Column)
            gap(12.px)
        }
        ".proj" style {
            background(surface)
            border(1.px, LineStyle.Solid, "rgba(135,147,140,0.12)")
            borderRadius(12.px)
            padding(16.px, 18.px)
            borderLeft(3.px, LineStyle.Solid, green)
            property("transition", "transform 0.2s, box-shadow 0.2s")
        }
        ".proj:hover" style {
            property("transform", "translateX(3px)")
            property("box-shadow", "0 0 24px rgba(0,241,94,0.07)")
        }
        ".proj-title" style {
            fontSize(15.px)
            fontWeight(600)
            color(white)
            marginBottom(8.px)
        }
        ".proj-desc" style {
            fontSize(12.px)
            color(muted)
            property("line-height", "1.65")
            marginBottom(10.px)
            padding(8.px, 12.px)
            background(green05)
            borderLeft(2.px, LineStyle.Solid, "rgba(0,241,94,0.2)")
            borderRadius(0.px, 5.px, 5.px, 0.px)
        }
        ".proj-badges" style {
            display(DisplayStyle.Flex)
            property("flex-wrap", "wrap")
            gap(5.px)
            marginBottom(10.px)
        }
        ".badge" style {
            fontFamily("'JetBrains Mono'", "monospace")
            fontSize(10.px)
            padding(2.px, 9.px)
            borderRadius(3.px)
            background("rgba(135,147,140,0.08)")
            color(muted)
            border(1.px, LineStyle.Solid, "rgba(135,147,140,0.13)")
        }
        ".badge-g" style {
            background(green05)
            color(green)
            borderColor("rgba(0,241,94,0.22)")
        }
        ".badge-p" style {
            background("rgba(127,82,255,0.08)")
            color(purple)
            borderColor("rgba(127,82,255,0.22)")
        }
        ".badge-r" style {
            background(red05)
            color(red)
            borderColor("rgba(187,61,61,0.22)")
        }
        ".proj-points" style { property("list-style", "none") }
        ".proj-point" style {
            fontSize(12.px)
            color(muted)
            padding(3.px, 0.px)
            display(DisplayStyle.Flex)
            gap(8.px)
            property("line-height", "1.5")
        }
        ".proj-point::before" style {
            property("content", "'›'")
            color(green)
            fontFamily("'JetBrains Mono'", "monospace")
            property("flex-shrink", "0")
        }
        ".proj-point strong" style {
            color(white)
            fontWeight(500)
        }

        // ── Code Block ───────────────────────────────────────────────────────
        ".code-block" style {
            background(surface)
            border(1.px, LineStyle.Solid, "rgba(135,147,140,0.12)")
            borderRadius(10.px)
            padding(18.px)
            property("overflow-x", "auto")
            position(Position.Relative)
        }
        ".code-block pre" style {
            fontFamily("'JetBrains Mono'", "monospace")
            fontSize(12.px)
            property("line-height", "1.75")
            color(white)
            property("white-space", "pre")
        }
        ".code-block::before" style {
            property("content", "'kotlin'")
            position(Position.Absolute)
            top(10.px); right(14.px)
            fontSize(10.px)
            color(muted40)
            property("letter-spacing", "0.06em")
        }
        ".kw" style { color(purple) }
        ".fn" style { color(green) }
        ".str" style { color("rgba(0,241,94,0.65)") }
        ".nm" style { color(white) }

        // ── Stats ────────────────────────────────────────────────────────────
        ".stats-grid" style {
            display(DisplayStyle.Grid)
            property("grid-template-columns", "1fr 1fr")
            gap(10.px)
        }
        ".stat-card" style {
            background(surface)
            border(1.px, LineStyle.Solid, "rgba(135,147,140,0.12)")
            borderRadius(10.px)
            padding(14.px, 16.px)
            property("text-align", "center")
        }
        ".stat-img" style {
            width(100.percent)
            borderRadius(6.px)
        }
        ".stats-langs" style {
            marginTop(10.px)
            property("text-align", "center")
        }
        ".stats-langs .stat-img" style { maxWidth(45.percent) }

        // ── Footer ───────────────────────────────────────────────────────────
        ".footer" style {
            property("text-align", "center")
            marginTop(40.px)
            paddingTop(20.px)
            borderTop(1.px, LineStyle.Solid, "rgba(0,241,94,0.08)")
        }
        ".footer-views" style {
            fontFamily("'JetBrains Mono'", "monospace")
            fontSize(11.px)
            color(muted)
            property("letter-spacing", "0.06em")
        }
        ".footer-username" style { color(green) }
        ".footer-quote" style {
            fontSize(13.px)
            color("rgba(135,147,140,0.5)")
            marginTop(10.px)
            fontStyle("italic")
        }
        ".footer-copy" style {
            fontFamily("'JetBrains Mono'", "monospace")
            fontSize(10.px)
            color("rgba(135,147,140,0.3)")
            marginTop(14.px)
        }

        // ── Animations ───────────────────────────────────────────────────────
        "@keyframes fadeUp" style {}
        "@keyframes pulse" style {}

        // ── Responsive ───────────────────────────────────────────────────────
        "@media (max-width: 600px)" style {}
    }
}