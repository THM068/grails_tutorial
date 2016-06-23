twitter.consumerKey='URMqIdMkJEmH2v83D77YGKQ3O'
twitter.consumerSecret='rNOw5tbaRdOc1AvYoqHa372du1ZT184S7l7TsY9Png09XnIEO'

// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.userLookup.userDomainClassName = 'com.sky.User'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'com.sky.UserRole'
grails.plugin.springsecurity.authority.className = 'com.sky.Role'
grails.plugin.springsecurity.securityConfigType='InterceptUrlMap'

grails.plugin.springsecurity.controllerAnnotations.staticRules = [
	[pattern: '/',               access: ['permitAll']],
	[pattern: '/error',          access: ['permitAll']],
	[pattern: '/index',          access: ['permitAll']],
	[pattern: '/index.gsp',      access: ['permitAll']],
	[pattern: '/shutdown',       access: ['permitAll']],
	[pattern: '/assets/**',      access: ['permitAll']],
	[pattern: '/**/js/**',       access: ['permitAll']],
	[pattern: '/**/css/**',      access: ['permitAll']],
	[pattern: '/**/images/**',   access: ['permitAll']],
	[pattern: '/**/favicon.ico', access: ['permitAll']]
]

grails.plugin.springsecurity.filterChain.chainMap = [
	[pattern: '/assets/**',      filters: 'none'],
	[pattern: '/**/js/**',       filters: 'none'],
	[pattern: '/**/css/**',      filters: 'none'],
	[pattern: '/**/images/**',   filters: 'none'],
	[pattern: '/**/favicon.ico', filters: 'none'],
	[pattern: '/**',             filters: 'JOINED_FILTERS']
]

grails.plugin.springsecurity.interceptUrlMap = [
		[pattern: '/',               access: ['permitAll']],
		[pattern: '/error',          access: ['permitAll']],
		[pattern: '/index',          access: ['permitAll']],
		[pattern: '/index.gsp',      access: ['permitAll']],
		[pattern: '/shutdown',       access: ['permitAll']],
		[pattern: '/assets/**',      access: ['permitAll']],
		[pattern: '/**/js/**',       access: ['permitAll']],
		[pattern: '/**/css/**',      access: ['permitAll']],
		[pattern: '/**/images/**',   access: ['permitAll']],
		[pattern: '/**/favicon.ico', access: ['permitAll']],
		[pattern: '/login',          access: ['permitAll']],
		[pattern: '/login/**',       access: ['permitAll']],
		[pattern: '/logout',         access: ['permitAll']],
		[pattern: '/logout/**',      access: ['permitAll']],
		[pattern: '/signin/**',       access: ['permitAll']],
		[pattern: '/connect/**',       access: ['permitAll']]
]

//grails.plugin.springsecurity.interceptUrlMap = [
//		'/favicon.ico': ['permitAll'],
//		"/login/**": ['permitAll'],
//		"/logout/**": ['permitAll'],
//		'/index': ['permitAll'],
//		'/assets/**': ['permitAll'],
//		'/**/js/**': ['permitAll'],
//		'/**/css/**': ['permitAll'],
//		'/**/images/**': ['permitAll'],
//		'/assets/favicon.ico': ['permitAll'],
//		'/signin/**': ['permitAll'],
//		"/": ['IS_AUTHENTICATED_FULLY'],
//		'/dashboard/**': ['IS_AUTHENTICATED_FULLY'],
//		'/employee/**': ['IS_AUTHENTICATED_FULLY'],
//		'/jobAdvert/**': ['IS_AUTHENTICATED_FULLY'],
//		'/api/**': ['permitAll'],
//		'/health': ['permitAll'],
//		'/info': ['permitAll'],
//		'/mappings': ['permitAll'],
//		'/metrics': ['permitAll'],
//		'/trace': ['permitAll'],
//		'/dump': ['permitAll'],
//		'/actuator/**': ['ROLE_ADMIN'],
//		'/logfile': ['ROLE_ADMIN'],
//		'/shutdown': ['ROLE_ADMIN'],
//		'/admin/**': ['ROLE_ADMIN'],
//		'/switch/**': ['ROLE_ADMIN'],
//		'/j_spring_security_switch_user/**': ['ROLE_ADMIN']
//]





