DESCRIPTION = "Enlightened Sound Daemon"
SECTION = "gpe/base"
LICENSE = "LGPLv2"
LIC_FILES_CHKSUM = "file://COPYING.LIB;md5=55ca817ccb7d5b5b66355690e9abc605"
DEPENDS = "alsa-lib audiofile"

inherit gnome binconfig update-rc.d

INITSCRIPT_NAME = "esound"
INITSCRIPT_PARAMS = "defaults 20" 
 
PR = "r4"

SRC_URI = "ftp://ftp.gnome.org/pub/GNOME/sources/esound/0.2/esound-0.2.41.tar.bz2;name=archive \
           file://init \
           file://no-docs.patch"

SRC_URI[archive.md5sum] = "8d9aad3d94d15e0d59ba9dc0ea990c6c"
SRC_URI[archive.sha256sum] = "5eb5dd29a64b3462a29a5b20652aba7aa926742cef43577bf0796b787ca34911"

EXTRA_OECONF = " \
    --enable-alsa \
    --disable-oss \
    --disable-arts \
    --disable-artstest \
"
do_configure_prepend() {
    sed -i -e 's:/usr/include/mme:${STAGING_INCDIR}/mme:g' ${S}/configure.ac
}

do_install_append () {

	install -d ${D}${sysconfdir}/init.d
	install -m 0755 ${WORKDIR}/init ${D}${sysconfdir}/init.d/esound
}
	
PACKAGES =+ "esddsp esd esd-utils"

FILES_esddsp = "${bindir}/esddsp ${libdir}/libesddsp.so.*"
#FILES_esd = "${bindir}/esd ${sysconfdir}/init.d/esound"
FILES_esd = "${bindir}/esd"
FILES_esd-utils = "${bindir}/*"

