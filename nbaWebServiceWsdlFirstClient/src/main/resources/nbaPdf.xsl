<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	xmlns:fo="http://www.w3.org/1999/XSL/Format">

	<!-- generate PDF page structure -->
	<xsl:template match="/">
		<fo:root>

			<fo:layout-master-set>
				<fo:simple-page-master
					master-name="A4-portrait" page-height="21cm" page-width="29.7cm"
					margin-top="1cm">
					<fo:region-body />
					<fo:region-before extent="0cm" />
				</fo:simple-page-master>
			</fo:layout-master-set>

			<fo:page-sequence master-reference="A4-portrait">
				<fo:flow flow-name="xsl-region-body">

					<fo:table table-layout="fixed" width="100%"
						border-color="green" border-width="0.1cm" border-style="solid"
						text-align="center">
						<fo:table-column column-width="10%"
							border-color="grey" border-width="0.05cm" border-style="solid" />
						<fo:table-column column-width="10%"
							border-color="grey" border-width="0.05cm" border-style="solid" />
						<fo:table-column column-width="10%"
							border-color="grey" border-width="0.05cm" border-style="solid" />
						<fo:table-column column-width="10%"
							border-color="grey" border-width="0.05cm" border-style="solid" />
						<fo:table-column column-width="10%"
							border-color="grey" border-width="0.05cm" border-style="solid" />
						<fo:table-column column-width="10%"
							border-color="grey" border-width="0.05cm" border-style="solid" />
						<fo:table-column column-width="10%"
							border-color="grey" border-width="0.05cm" border-style="solid" />
						<fo:table-column column-width="10%"
							border-color="grey" border-width="0.05cm" border-style="solid" />
						<fo:table-column column-width="10%"
							border-color="grey" border-width="0.05cm" border-style="solid" />
						<fo:table-column column-width="10%"
							border-color="grey" border-width="0.05cm" border-style="solid" />
						<fo:table-body>

							<fo:table-row height="16mm" border-color="green"
								border-width="0.1cm" border-style="solid" text-align="center"
								display-align="center" space-after="4mm">
								<fo:table-cell>
									<fo:block>First Name</fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block>Last Name</fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block>Age</fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block>Height</fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block>Weight</fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block>Nationality</fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block>Status</fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block>Games Played</fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block>Wins</fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block>Losses</fo:block>
								</fo:table-cell>
							</fo:table-row>

							<xsl:apply-templates
								select="nba/players/player" />

						</fo:table-body>
					</fo:table>

				</fo:flow>
			</fo:page-sequence>
		</fo:root>
	</xsl:template>

	<xsl:template match="nba/players/player">
		<fo:table-row border-color="grey" border-width="0.05cm"
			border-style="solid">
			<fo:table-cell>
				<fo:block>
					<xsl:value-of select="firstName" />
				</fo:block>
			</fo:table-cell>

			<fo:table-cell>
				<fo:block>
					<xsl:value-of select="lastName" />
				</fo:block>
			</fo:table-cell>

			<fo:table-cell>
				<fo:block>
					<xsl:value-of select="age" />
				</fo:block>
			</fo:table-cell>

			<fo:table-cell>
				<fo:block>
					<xsl:value-of select="height" />
				</fo:block>
			</fo:table-cell>

			<fo:table-cell>
				<fo:block>
					<xsl:value-of select="weight" />
				</fo:block>
			</fo:table-cell>

			<fo:table-cell>
				<fo:block>
					<xsl:value-of select="nationality" />
				</fo:block>
			</fo:table-cell>

			<fo:table-cell>
				<fo:block>
					<xsl:value-of select="status" />
				</fo:block>
			</fo:table-cell>

			<fo:table-cell>
				<fo:block>
					<xsl:value-of select="record/gamesplayed" />
				</fo:block>
			</fo:table-cell>

			<fo:table-cell>
				<fo:block>
					<xsl:value-of select="record/wins" />
				</fo:block>
			</fo:table-cell>

			<fo:table-cell>
				<fo:block>
					<xsl:value-of select="record/losses" />
				</fo:block>
			</fo:table-cell>
		</fo:table-row>
	</xsl:template>
</xsl:stylesheet>