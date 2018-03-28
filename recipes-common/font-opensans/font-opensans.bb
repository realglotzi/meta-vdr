SUMMARY = "Open Sans is a humanist sans serif typeface"
LICENSE = "Apache-2.0"
AUTHOR = "Steve Matteson"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=d273d63619c9aeaf15cdaf76422c4f87"

SRC_URI = "https://fonts.google.com/download?family=Open%20Sans;downloadfilename=open-sans-fonts.zip"

PR="r3"

SRC_URI[md5sum] = "bc58a717471519a7f4a5f40a74285477"
SRC_URI[sha256sum] = "ba3df6c0e20f2aea2a1f233c443402605d52d8b46a76fe0debfa2bf25c3fe049"

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
