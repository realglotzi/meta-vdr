SUMMARY = "This is the base package of the GraphLCD project"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=393a5ca445f6965873eca0259a17f833"

SRCREV = "e9ab0b821e9c0db017d1cedcd0b7043c1d4b7299"
SRC_URI = "git://projects.vdr-developer.org/graphlcd-base.git \
           file://graphlcd.conf \
          "
PR="r0"

S = "${WORKDIR}/git"

DEPENDS = " \
	libusb \
	freetype \
	imagemagick6 \
"
# GNU hash is missing, skip QA
INSANE_SKIP_${PN} = "ldflags"

EXTRA_OEMAKE = "DESTDIR=\"${D}\" 'INCLUDES=-I${STAGING_INCDIR}/freetype2 -I${STAGING_INCDIR}/ImageMagick-6 -I${S}' LIBS=-L${STAGING_LIBDIR} 'LDFLAGS=-lfreetype -lMagick++-6.Q16 -lusb' HAVE_IMAGEMAGICK=1 HAVE_DRIVER_AX206DPF=1"

do_install() {
	install -d "${D}/${sysconfdir}"
	install -m 755 graphlcd.conf ${D}/${sysconfdir}

	install -d "${D}/${sysconfdir}/udev/rules.d/"
	oe_runmake DESTDIR=${D} BINDIR=${bindir} LIBDIR=${libdir} INCDIR=${includedir} UDEVRULESDIR="${sysconfdir}/udev/rules.d/" install
}

FILES_${PN} = "${sysconfdir}/graphlcd.conf ${sysconfdir}/udev/rules.d/* ${bindir}/* ${libdir}/libglcd* ${includedir}/*"

