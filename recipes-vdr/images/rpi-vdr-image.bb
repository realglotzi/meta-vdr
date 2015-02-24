include recipes-core/images/core-image-minimal.bb

IMAGE_FEATURES += "package-management ssh-server-dropbear"

IMAGE_INSTALL += " \
	kernel-modules \
	tiny-init \
	cpufrequtils \
	procps \
	console-tools \
	util-linux \
	nfs-utils \
	ntpclient \
	tzdata \
	ttf-bitstream-vera \
	irmplircd \
	ceclircd \
	vtunerc \
	satip-client \
	graphlcd-base-ax206dpf \
	runvdr-extreme \
	vdr-font-symbols \
	vdr \
	vdr-locale-de-de \
	vdr-plugin-mlist \
	vdr-plugin-mlist-locale-de-de \
	vdr-plugin-femon \
	vdr-plugin-femon-locale-de-de \
	vdr-plugin-satip \
	vdr-plugin-satip-locale-de-de \
	vdr-plugin-graphlcd-ax206dpf \
	vdr-plugin-graphlcd-ax206dpf-locale-de-de \
	vdr-plugin-svdrpservice \
	vdr-plugin-svdrpservice-locale-de-de \
	vdr-plugin-remotetimers \
	vdr-plugin-remotetimers-locale-de-de \
	vdr-plugin-epgsync \
	vdr-plugin-epgsync-locale-de-de \
	vdr-plugin-neutrinoepg \
	vdr-plugin-neutrinoepg-locale-de-de \
	vdr-plugin-rpihddevice \
	vdr-plugin-rpihddevice-locale-de-de \
	vdr-plugin-skinsoppalusikka \
	vdr-plugin-skinsoppalusikka-locale-de-de \
	vdr-plugin-skinenigmang \
	vdr-plugin-skinenigmang-locale-de-de \
	vdr-plugin-streamdev \
	vdr-plugin-streamdev-locale-de-de \
	vdr-plugin-extrecmenu \
	vdr-plugin-extrecmenu-locale-de-de \
	vdr-plugin-remote \
	vdr-plugin-remote-locale-de-de \
	vdr-plugin-cecremote \
	vdr-plugin-skinenigmang-logos-xpm-hi"
	
IMAGE_INSTALL += " glibc-utils \
	glibc-binaries \
	glibc-binary-localedata-de-de \
	glibc-localedata-de-de \
	locale-base-de-de \
	localedef \
	glibc-charmap-iso-8859-1 \
	glibc-charmap-iso-8859-15 \
	glibc-charmap-utf-8 \
	glibc-gconv-iso8859-1 \
	glibc-gconv-iso8859-15 \
	glibc-gconv-unicode "
	
export IMAGE_BASENAME="rpi-vdr-image"

