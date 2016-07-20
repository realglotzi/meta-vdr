SUMMARY = "Open Sans is a humanist sans serif typeface"
LICENSE = "Apache-2.0"
AUTHOR = "Steve Matteson"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=d273d63619c9aeaf15cdaf76422c4f87"

SRC_URI = " http://www.google.com/fonts/download?kit=3hvsV99qyKCBS55e5pvb3ltkqrIMaAZWyLYEoB48lSQ;downloadfilename=open-sans-fonts.zip"

PR="r1"

SRC_URI[md5sum] = "1ee77536f01277a6826cc7bb87433160"
SRC_URI[sha256sum] = "b1e0925c81122343c10b4bd4f7406120394eee5203748a6ce9693e68780d090a"

S = "${WORKDIR}"

do_install() {
	install -d ${D}/usr/share/fonts
	install -m 0755 ${S}/OpenSans-BoldItalic.ttf      ${D}/usr/share/fonts
	install -m 0755 ${S}/OpenSans-Bold.ttf            ${D}/usr/share/fonts
	install -m 0755 ${S}/OpenSans-ExtraBoldItalic.ttf ${D}/usr/share/fonts
	install -m 0755 ${S}/OpenSans-ExtraBold.ttf       ${D}/usr/share/fonts
	install -m 0755 ${S}/OpenSans-Italic.ttf          ${D}/usr/share/fonts
	install -m 0755 ${S}/OpenSans-LightItalic.ttf     ${D}/usr/share/fonts
	install -m 0755 ${S}/OpenSans-Light.ttf           ${D}/usr/share/fonts
	install -m 0755 ${S}/OpenSans-Regular.ttf         ${D}/usr/share/fonts
	install -m 0755 ${S}/OpenSans-SemiboldItalic.ttf  ${D}/usr/share/fonts
	install -m 0755 ${S}/OpenSans-Semibold.ttf        ${D}/usr/share/fonts
}

FILES_${PN} += "${datadir}/fonts/*.ttf"
