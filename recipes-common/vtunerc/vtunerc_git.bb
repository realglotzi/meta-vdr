DESCIPTION = "tweaked vtuner for satip client"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COMMITERS;md5=a6e35f252413adfbe74206af8ca9fdbb"

PR = "r0"

SRCREV = "a72d5083b2a54c2611bb2039cda0a076500442f5"
SRC_URI = "git://code.google.com/p/satip;protocol=https"

S = "${WORKDIR}/git/vtuner_tweak"

PACKAGE_ARCH = "${MACHINE_ARCH}"

DEPENDS += "virtual/kernel"

inherit module

MODULE_MAKE_FLAGS = '\
	KSRC=${STAGING_KERNEL_DIR} \
	KERNEL_PATH=${STAGING_KERNEL_DIR} \
	KERNEL_SRC=${STAGING_KERNEL_DIR} \
	KDIR=${STAGING_KERNEL_DIR} \
	KERNELDIR=${STAGING_KERNEL_DIR} \
	KERNEL_DIR=${STAGING_KERNEL_DIR} \
    KERNEL_VERSION=${KERNEL_VERSION} \
	CC="${KERNEL_CC}" LD="${KERNEL_LD}" \
	AR="${KERNEL_AR}" \
	'

do_compile () {
        unset CFLAGS CPPFLAGS CXXFLAGS LDFLAGS                                                                                          
        oe_runmake ${MODULE_MAKE_FLAGS} ${MAKE_TARGETS}         		
}

do_install () {
	install -d ${D}/lib/modules/${KERNEL_VERSION}/kernel/drivers/media/tuners
	install -m 755 ${S}/vtunerc.ko ${D}/lib/modules/${KERNEL_VERSION}/kernel/drivers/media/tuners
}
