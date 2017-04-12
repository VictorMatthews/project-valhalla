package com.nfpenterprise.gameHub.constants;

public enum Flaws {
	//@formatter:off

	ACOLYTE_1			(Backgrounds.ACOLYTE.getBackgroundId(), 	"I judge others harshly, and myselfeven more severely."),
	ACOLYTE_2			(Backgrounds.ACOLYTE.getBackgroundId(), 	"I put too much trust in those who wield power within my temple’s hierarchy."),
	ACOLYTE_3			(Backgrounds.ACOLYTE.getBackgroundId(), 	"My piety sometimes leads me to blindly trust those that profess faith in my god."),
	ACOLYTE_4			(Backgrounds.ACOLYTE.getBackgroundId(), 	"I am inflexible in my thinking."),
	ACOLYTE_5			(Backgrounds.ACOLYTE.getBackgroundId(), 	"I am suspicious of strangers and expect the worst of them."),
	ACOLYTE_6			(Backgrounds.ACOLYTE.getBackgroundId(), 	"Once I pick a goal, I become obsessed with it to the detriment of everything else in my life."),

	CHARLATAN_1			(Backgrounds.CHARLATAN.getBackgroundId(), 	"I can’t resist a pretty face."),
	CHARLATAN_2			(Backgrounds.CHARLATAN.getBackgroundId(), 	"I'm always in debt. I spend my ill-gotten gains on decadent luxuries faster than I bring them in.."),
	CHARLATAN_3			(Backgrounds.CHARLATAN.getBackgroundId(), 	"I’m convinced that no one could ever fool me the way Ifool others."),
	CHARLATAN_4			(Backgrounds.CHARLATAN.getBackgroundId(), 	"I’m too greedy for my own good. Ican’t resist taking a risk if there’s money involved."),
	CHARLATAN_5			(Backgrounds.CHARLATAN.getBackgroundId(), 	"I can’t resist swindling people who are more powerful than me."),
	CHARLATAN_6			(Backgrounds.CHARLATAN.getBackgroundId(), 	"I hate to admit it and will hate myself for it, but I'll run and preserve my own hide if the going gets tough"),

	CRIMINAL_1 			(Backgrounds.CRIMINAL.getBackgroundId(), 	"When I see something valuable, I can't think about anything but how to steal it."),
	CRIMINAL_2			(Backgrounds.CRIMINAL.getBackgroundId(), 	"When faced with a choice between money and my friends, I usually choose the money."),
	CRIMINAL_3			(Backgrounds.CRIMINAL.getBackgroundId(), 	"If there's a plan, I'll forget it. If I don't forget it, I'll ignore it."),
	CRIMINAL_4			(Backgrounds.CRIMINAL.getBackgroundId(), 	"I have a 'tell' that reveals when I'm lying."),
	CRIMINAL_5			(Backgrounds.CRIMINAL.getBackgroundId(), 	"I turn tail and run when things go bad."),
	CRIMINAL_6			(Backgrounds.CRIMINAL.getBackgroundId(), 	"An innocent person is in prison for a crime that I committed. I'm okay with that."),

	ENTERTAINER_1		(Backgrounds.ENTERTAINER.getBackgroundId(), 	"I'll do anything to win fame and renown."),
	ENTERTAINER_2		(Backgrounds.ENTERTAINER.getBackgroundId(), 	"I'm a sucker for a pretty face."),
	ENTERTAINER_3		(Backgrounds.ENTERTAINER.getBackgroundId(), 	"A scandal prevents me from ever going home again. That kind of trouble seems to follow me around."),
	ENTERTAINER_4		(Backgrounds.ENTERTAINER.getBackgroundId(), 	"I once satirized a noble who still wants my head. It was a mistake that I will likely repeat."),
	ENTERTAINER_5		(Backgrounds.ENTERTAINER.getBackgroundId(), 	"I have trouble keeping my true feelings hidden. My sharp tongue lands me in trouble."),
	ENTERTAINER_6		(Backgrounds.ENTERTAINER.getBackgroundId(), 	"Despite my best efforts, I am unreliable to my friends."),

	FOLK_HERO_1			(Backgrounds.FOLK_HERO.getBackgroundId(), 	"The tyrant who rules my land will stop at nothing to see me killed."),
	FOLK_HERO_2			(Backgrounds.FOLK_HERO.getBackgroundId(), 	"I'm convinced of the significance of my destiny, and blind to my shortcomings and the risk of failure."),
	FOLK_HERO_3			(Backgrounds.FOLK_HERO.getBackgroundId(), 	"The people who knew me when I was young know my shameful secret, so I can never go home again."),
	FOLK_HERO_4			(Backgrounds.FOLK_HERO.getBackgroundId(), 	"I have a weakness for the vices of the city, especially hard drink."),
	FOLK_HERO_5			(Backgrounds.FOLK_HERO.getBackgroundId(), 	"Secretly, I believe that things would be better if I were a tyrant lording over the land."),
	FOLK_HERO_6			(Backgrounds.FOLK_HERO.getBackgroundId(), 	"I have trouble trusting in my allies."),

	GUILD_ARTISAN_1		(Backgrounds.GUILD_ARTISAN.getBackgroundId(), 	"I'll do anything to get my hands on something rare or priceless."),
	GUILD_ARTISAN_2		(Backgrounds.GUILD_ARTISAN.getBackgroundId(), 	"I'm quick to assume that someone is trying to cheat me."),
	GUILD_ARTISAN_3		(Backgrounds.GUILD_ARTISAN.getBackgroundId(), 	"No one must ever learn that I once stole money from guild coffers."),
	GUILD_ARTISAN_4		(Backgrounds.GUILD_ARTISAN.getBackgroundId(), 	"I'm never satisfied with what I have--I always want more."),
	GUILD_ARTISAN_5		(Backgrounds.GUILD_ARTISAN.getBackgroundId(), 	"I would kill to acquire a noble title."),
	GUILD_ARTISAN_6		(Backgrounds.GUILD_ARTISAN.getBackgroundId(), 	"I'm horribly jealous of anyone who outshines my handiwork. Everywhere I go, I'm surrounded by rivals."),

	HERMIT_1			(Backgrounds.HERMIT.getBackgroundId(), 	"Now that I've returned to the world, I enjoy its delights a little too much."),
	HERMIT_2			(Backgrounds.HERMIT.getBackgroundId(), 	"I harbor dark bloodthirsty thoughts that my isolation failed to quell."),
	HERMIT_3			(Backgrounds.HERMIT.getBackgroundId(), 	"I am dogmatic in my thoughts and philosophy."),
	HERMIT_4			(Backgrounds.HERMIT.getBackgroundId(), 	"I let my need to win arguments overshadow friendships and harmony."),
	HERMIT_5			(Backgrounds.HERMIT.getBackgroundId(), 	"I'd risk too much to uncover a lost bit of knowledge."),
	HERMIT_6			(Backgrounds.HERMIT.getBackgroundId(), 	"I like keeping secrets and won't share them with anyone."),

	NOBLE_1				(Backgrounds.NOBLE.getBackgroundId(), 	"I secretly believe that everyone is beneath me."),
	NOBLE_2				(Backgrounds.NOBLE.getBackgroundId(), 	"I hide a truly scandalous secret that could ruin my family forever."),
	NOBLE_3				(Backgrounds.NOBLE.getBackgroundId(), 	"I too often hear veiled insults and threats in every word addressed to me, and I'm quick to anger."),
	NOBLE_4				(Backgrounds.NOBLE.getBackgroundId(), 	"I have an insatiable desire for carnal pleasures."),
	NOBLE_5				(Backgrounds.NOBLE.getBackgroundId(), 	"In fact, the world does revolve around me."),
	NOBLE_6				(Backgrounds.NOBLE.getBackgroundId(), 	"By my words and actions, I often bring shame to my family."),

	OUTLANDER_1			(Backgrounds.OUTLANDER.getBackgroundId(), 	"I am too enamored of ale, wine, and other intoxicants."),
	OUTLANDER_2			(Backgrounds.OUTLANDER.getBackgroundId(), 	"There's no room for caution in a life lived to the fullest."),
	OUTLANDER_3			(Backgrounds.OUTLANDER.getBackgroundId(), 	"I remember every insult I've received and nurse a silent resentment toward anyone who's ever wronged me."),
	OUTLANDER_4			(Backgrounds.OUTLANDER.getBackgroundId(), 	"I am slow to trust members of other races"),
	OUTLANDER_5			(Backgrounds.OUTLANDER.getBackgroundId(), 	"Violence is my answer to almost any challenge."),
	OUTLANDER_6			(Backgrounds.OUTLANDER.getBackgroundId(), 	"Don't expect me to save those who can't save themselves. It is nature's way that the strong thrive and the weak perish."),

	SAGE_1				(Backgrounds.SAGE.getBackgroundId(), 	"I am easily distracted by the promise of information."),
	SAGE_2				(Backgrounds.SAGE.getBackgroundId(), 	"Most people scream and run when they see a demon. I stop and take notes on its anatomy."),
	SAGE_3				(Backgrounds.SAGE.getBackgroundId(), 	"Unlocking an ancient mystery is worth the price of a civilization."),
	SAGE_4				(Backgrounds.SAGE.getBackgroundId(), 	"I overlook obvious solutions in favor of complicated ones."),
	SAGE_5				(Backgrounds.SAGE.getBackgroundId(), 	"I speak without really thinking through my words, invariably insulting others."),
	SAGE_6				(Backgrounds.SAGE.getBackgroundId(), 	"I can't keep a secret to save my life, or anyone else's."),

	SAILOR_1			(Backgrounds.SAILOR.getBackgroundId(), 	"I follow orders, even if I think they're wrong."),
	SAILOR_2			(Backgrounds.SAILOR.getBackgroundId(), 	"I'll say anything to avoid having to do extra work."),
	SAILOR_3			(Backgrounds.SAILOR.getBackgroundId(), 	"Once someone questions my courage, I never back down no matter how dangerous the situation."),
	SAILOR_4			(Backgrounds.SAILOR.getBackgroundId(), 	"Once I start drinking, it's hard for me to stop."),
	SAILOR_5			(Backgrounds.SAILOR.getBackgroundId(), 	"I can't help but pocket loose coins and other trinkets I come across."),
	SAILOR_6			(Backgrounds.SAILOR.getBackgroundId(), 	"My pride will probably lead to my destruction"),

	SOLDIER_1			(Backgrounds.SOLDIER.getBackgroundId(), 	"The monstrous enemy we faced in battle still leaves me quivering with fear."),
	SOLDIER_2			(Backgrounds.SOLDIER.getBackgroundId(), 	"I have little respect for anyone who is not a proven warrior."),
	SOLDIER_3			(Backgrounds.SOLDIER.getBackgroundId(), 	"I made a terrible mistake in battle that cost many lives--and I would do anything to keep that mistake secret."),
	SOLDIER_4			(Backgrounds.SOLDIER.getBackgroundId(), 	"My hatred of my enemies is blind and unreasoning."),
	SOLDIER_5			(Backgrounds.SOLDIER.getBackgroundId(), 	"I obey the law, even if the law causes misery."),
	SOLDIER_6			(Backgrounds.SOLDIER.getBackgroundId(), 	"I'd rather eat my armor than admit when I'm wrong."),

	URCHIN_1			(Backgrounds.URCHIN.getBackgroundId(), 	"If I'm outnumbered, I always run away from a fight."),
	URCHIN_2			(Backgrounds.URCHIN.getBackgroundId(), 	"Gold seems like a lot of money to me, and I'll do just about anything for more of it."),
	URCHIN_3			(Backgrounds.URCHIN.getBackgroundId(), 	"I will never fully trust anyone other than myself."),
	URCHIN_4			(Backgrounds.URCHIN.getBackgroundId(), 	"I'd rather kill someone in their sleep than fight fair."),
	URCHIN_5			(Backgrounds.URCHIN.getBackgroundId(), 	"It's not stealing if I need it more than someone else."),
	URCHIN_6			(Backgrounds.URCHIN.getBackgroundId(), 	"People who don't take care of themselves get what they deserve.");


	//@formatter:on

	private final Integer backgroundId;
	private final String flawText;

	Flaws(Integer backgroundId, String flawText) {
		this.backgroundId = backgroundId;
		this.flawText = flawText;
	}

	public Integer getBackgroundId() {
		return backgroundId;
	}

	public String getFlawText() {
		return flawText;
	}

	public static Flaws[] getFlaws() {
		return Flaws.values();
	}

	@Override
	public String toString() {
		return this.flawText;
	}

}
