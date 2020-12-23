SUMMARY = "Open Sans is a humanist sans serif typeface"
LICENSE = "Apache-2.0"
AUTHOR = "Steve Matteson"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=d273d63619c9aeaf15cdaf76422c4f87"

SRC_URI = "https://fonts.google.com/download?family=Open%20Sans;downloadfilename=open-sans-fonts.zip"

PR="r4"

SRC_URI[md5sum] = "5355c7de26698be12160d21e547e17b6"
SRC_URI[sha256sum] = "da00d6f00a99963ca7e1a5869e3bbf530d57ce61f18e033b9f8c49c30b7043f2"

DEPENDS = "unzip-native"

S = "${WORKDIR}"

do_unpack[depends] += "unzip-native:do_populate_sysroot"

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
	install -m 0755 ${S}/OpenSans-SemiBoldItalic.ttf  ${D}/usr/share/fonts
	install -m 0755 ${S}/OpenSans-SemiBold.ttf        ${D}/usr/share/fonts
}

FILES_${PN} += "${datadir}/fonts/*.ttf"
