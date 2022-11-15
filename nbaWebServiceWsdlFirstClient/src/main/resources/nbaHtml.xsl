<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

	<xsl:template match="/">
		<html>
			<body
				style="font-family:Arial;font-size:12pt;background-color:#5FBC1B">
				<h2>Greatest of All Time</h2>

				<table border="1">
					<tr bgcolor="white">
						<th>First Name</th>
						<th>Last Name</th>
						<th>Age</th>
						<th>Height</th>
						<th>Weight</th>
						<th>Nationality</th>
						<th>Status</th>
						<th colspan="2">Record</th>
					</tr>
					<xsl:for-each select="nba/players/player">
						<tr bgcolor="grey">
							<td>
								<xsl:value-of select="firstName" />
							</td>
							<td>
								<xsl:value-of select="lastName" />
							</td>
							<td>
								<xsl:value-of select="age" />
							</td>
							<td>
								<xsl:value-of select="height" />
							</td>
							<td>
								<xsl:value-of select="weight" />
							</td>
							<td>
								<xsl:value-of select="nationality" />
							</td>
							<td>
								<xsl:value-of select="status" />
							</td>
							<td>
								<xsl:value-of select="record/gamesplayed" />
							</td>
							<td>
								<xsl:value-of select="record/wins" />
							</td>
							<td>
								<xsl:value-of select="record/losses" />
							</td>
						</tr>
					</xsl:for-each>
				</table>
			</body>
		</html>
	</xsl:template>
</xsl:stylesheet>
