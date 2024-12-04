plugins {
	id("java")
	alias(libs.plugins.shadow)
}

group = "org.muonmc"
version = "0.1.0"

repositories {
	mavenCentral()
}

dependencies {
	shadow(libs.asm)
	implementation(libs.asm)

	testImplementation(platform("org.junit:junit-bom:5.10.0"))
	testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
	useJUnitPlatform()
}

tasks.shadowJar {
	relocate("org.objectweb.asm", "org.muonmc.snasm.shadow.asm")
}
