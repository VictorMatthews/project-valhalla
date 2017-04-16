package com.nfpenterprise.gameHub.constants;

public enum PersonalityTraits {
	//@formatter:off

	ACOLYTE_1			(Backgrounds.ACOLYTE.getBackgroundId(), 	"I idolize a particular hero o f my faith, and constantly refer to that person’s deeds and example."),
	ACOLYTE_2			(Backgrounds.ACOLYTE.getBackgroundId(), 	"I can find common ground between the fiercest enemies, empathizing with them and always working towards peace."),
	ACOLYTE_3			(Backgrounds.ACOLYTE.getBackgroundId(), 	"I see omens in every event and action. The gods try to speak to us, we just need to listen."),
	ACOLYTE_4			(Backgrounds.ACOLYTE.getBackgroundId(), 	"Nothing can shake my optimistic attitude."),
	ACOLYTE_5			(Backgrounds.ACOLYTE.getBackgroundId(), 	"I quote (or misquote) sacred texts and proverbs in almost every situation."),
	ACOLYTE_6			(Backgrounds.ACOLYTE.getBackgroundId(), 	"I am tolerant (or intolerant) of other faiths and respect (or condemn) the worship of other gods."),
	ACOLYTE_7			(Backgrounds.ACOLYTE.getBackgroundId(), 	"I've enjoyed fine food, drink, and high society among my temple’s elite. Rough living grates on me."),
	ACOLYTE_8			(Backgrounds.ACOLYTE.getBackgroundId(), 	"I’ve spent so long in the temple that I have little practical experience dealing with people in the outside world."),

	CHARLATAN_1			(Backgrounds.CHARLATAN.getBackgroundId(), 	"I fall in and out of love easily, and am always pursuing someone."),
	CHARLATAN_2			(Backgrounds.CHARLATAN.getBackgroundId(), 	"I have ajoke for every occasion, especially occasions where humor is inappropriate."),
	CHARLATAN_3			(Backgrounds.CHARLATAN.getBackgroundId(), 	"Flattery is my preferred trick for getting what I want."),
	CHARLATAN_4			(Backgrounds.CHARLATAN.getBackgroundId(), 	"I’m a born gambler who can't resist taking a risk for a potential payoff."),
	CHARLATAN_5			(Backgrounds.CHARLATAN.getBackgroundId(), 	"I lie about almost everything, even when there’s no good reason to."),
	CHARLATAN_6			(Backgrounds.CHARLATAN.getBackgroundId(), 	"Sarcasm and insults are my weapons of choice."),
	CHARLATAN_7			(Backgrounds.CHARLATAN.getBackgroundId(), 	"I keep multiple holy symbols on me and invoke whatever deity might come in useful at any given moment."),
	CHARLATAN_8			(Backgrounds.CHARLATAN.getBackgroundId(), 	"I pocket anything I see that might have some value."),

	CRIMINAL_1 			(Backgrounds.CRIMINAL.getBackgroundId(), 	"I always have a plan for what to do when things go wrong"),
	CRIMINAL_2			(Backgrounds.CRIMINAL.getBackgroundId(), 	"I am always calm, no matter what the situation. I never raice my voice or let my emotions control me"),
	CRIMINAL_3			(Backgrounds.CRIMINAL.getBackgroundId(), 	"The first thing I do in a new place is note the locations of everything valuable--or where such things could be hidden."),
	CRIMINAL_4			(Backgrounds.CRIMINAL.getBackgroundId(), 	"I would rather make a new friend than a new enemy."),
	CRIMINAL_5			(Backgrounds.CRIMINAL.getBackgroundId(), 	"I am incredibly slow to trust. Those who seem the fairest often have the most to hide."),
	CRIMINAL_6			(Backgrounds.CRIMINAL.getBackgroundId(), 	"I don't pay attention to the risks in a situation. Never tell me the odds."),
	CRIMINAL_7			(Backgrounds.CRIMINAL.getBackgroundId(), 	"The best way to get me to do something is to tell me I can't do it."),
	CRIMINAL_8			(Backgrounds.CRIMINAL.getBackgroundId(), 	"I blow up at the slightest insult."),

	ENTERTAINER_1		(Backgrounds.ENTERTAINER.getBackgroundId(), 	"I know a story relevant to almost every situation."),
	ENTERTAINER_2		(Backgrounds.ENTERTAINER.getBackgroundId(), 	"Whenever I come to a new place, I collect local rumors and spread gossip."),
	ENTERTAINER_3		(Backgrounds.ENTERTAINER.getBackgroundId(), 	"I'm a hopeless romantic, always searching for that 'special someone'."),
	ENTERTAINER_4		(Backgrounds.ENTERTAINER.getBackgroundId(), 	"Nobody stays angry at me or around me for long, since I can defuse any amount of tension."),
	ENTERTAINER_5		(Backgrounds.ENTERTAINER.getBackgroundId(), 	"I love a good insult, even one directed at me."),
	ENTERTAINER_6		(Backgrounds.ENTERTAINER.getBackgroundId(), 	"I get bitter if I'm not the center of attention."),
	ENTERTAINER_7		(Backgrounds.ENTERTAINER.getBackgroundId(), 	"I'll settle for nothing less than perfection."),
	ENTERTAINER_8		(Backgrounds.ENTERTAINER.getBackgroundId(), 	"I change my mood or my mind as quickly as I change key in a song."),

	FOLK_HERO_1			(Backgrounds.FOLK_HERO.getBackgroundId(), 	"I judge people by their actions, not their words."),
	FOLK_HERO_2			(Backgrounds.FOLK_HERO.getBackgroundId(), 	"If someone is in trouble, I'm always willing to lend help."),
	FOLK_HERO_3			(Backgrounds.FOLK_HERO.getBackgroundId(), 	"When I set my mind to something, I follow through no matter what gets in my way."),
	FOLK_HERO_4			(Backgrounds.FOLK_HERO.getBackgroundId(), 	"I have a strong sense of fair play and always try to find the most equitable solution to arguments."),
	FOLK_HERO_5			(Backgrounds.FOLK_HERO.getBackgroundId(), 	"I'm confident in my own abilities and do what I can to instill confidence in others."),
	FOLK_HERO_6			(Backgrounds.FOLK_HERO.getBackgroundId(), 	"Thinking is for other people. I prefer action."),
	FOLK_HERO_7			(Backgrounds.FOLK_HERO.getBackgroundId(), 	"I misuse long words in an attempt to sound smarter."),
	FOLK_HERO_8			(Backgrounds.FOLK_HERO.getBackgroundId(), 	"I get bored easily. When am I going to get on with my destiny."),

	GUILD_ARTISAN_1		(Backgrounds.GUILD_ARTISAN.getBackgroundId(), 	"I believe that everything worth doing is worth doing right. I can't help it--I'm a perfectionist."),
	GUILD_ARTISAN_2		(Backgrounds.GUILD_ARTISAN.getBackgroundId(), 	"I'm a snob who looks down on those who can't appreciate fine art."),
	GUILD_ARTISAN_3		(Backgrounds.GUILD_ARTISAN.getBackgroundId(), 	"I always want to know how things work and what makes people tick."),
	GUILD_ARTISAN_4		(Backgrounds.GUILD_ARTISAN.getBackgroundId(), 	"I'm full of witty aphorisms and have a proverb for every occasion."),
	GUILD_ARTISAN_5		(Backgrounds.GUILD_ARTISAN.getBackgroundId(), 	"I'm rude to people who lack my commitment to hard work and fair play."),
	GUILD_ARTISAN_6		(Backgrounds.GUILD_ARTISAN.getBackgroundId(), 	"I like to talk at length about my profession."),
	GUILD_ARTISAN_7		(Backgrounds.GUILD_ARTISAN.getBackgroundId(), 	"I don't part with my money easily and will haggle tirelessly to get the best deal possible."),
	GUILD_ARTISAN_8		(Backgrounds.GUILD_ARTISAN.getBackgroundId(), 	"I'm well known for my work, and I want to make sure everyone appreciates it. I'm always taken aback when people haven't heard of me."),

	HERMIT_1			(Backgrounds.HERMIT.getBackgroundId(), 	"I've been isolated for so long that I rarely speak, preferring gestures and the occasional grunt."),
	HERMIT_2			(Backgrounds.HERMIT.getBackgroundId(), 	"I am utterly serene, even in the face of disaster."),
	HERMIT_3			(Backgrounds.HERMIT.getBackgroundId(), 	"The leader of my community has something wise to say on every topic, and I am eager to share that wisdom."),
	HERMIT_4			(Backgrounds.HERMIT.getBackgroundId(), 	"I feel tremendous empathy for all who suffer."),
	HERMIT_5			(Backgrounds.HERMIT.getBackgroundId(), 	"I'm oblivious to etiquette and social expectations."),
	HERMIT_6			(Backgrounds.HERMIT.getBackgroundId(), 	"I connect everything that happens to me to a grand cosmic plan."),
	HERMIT_7			(Backgrounds.HERMIT.getBackgroundId(), 	"I often get lost in my own thoughts and contemplations, becoming oblivious to my surroundings."),
	HERMIT_8			(Backgrounds.HERMIT.getBackgroundId(), 	"I am working on a grand philosophical theory and love sharing my ideas."),

	NOBLE_1				(Backgrounds.NOBLE.getBackgroundId(), 	"My eloquent flattery makes everyone I talk to feel like the most wonderful and important person in the world."),
	NOBLE_2				(Backgrounds.NOBLE.getBackgroundId(), 	"The common folk love me for my kindness and generosity."),
	NOBLE_3				(Backgrounds.NOBLE.getBackgroundId(), 	"No one could doubt by looking at my regal bearing that I am a cut above the unwashed masses."),
	NOBLE_4				(Backgrounds.NOBLE.getBackgroundId(), 	"I take great pains to always look my best and follow the latest fashions."),
	NOBLE_5				(Backgrounds.NOBLE.getBackgroundId(), 	"I don't like to get my hands dirty, and I won't be caught dead in unsuitable accommodations."),
	NOBLE_6				(Backgrounds.NOBLE.getBackgroundId(), 	"Despite my birth, I do not place myself above other folk. We all have the same blood."),
	NOBLE_7				(Backgrounds.NOBLE.getBackgroundId(), 	"My favor, once lost, is lost forever."),
	NOBLE_8				(Backgrounds.NOBLE.getBackgroundId(), 	"If you do me an injury, I will crush you, ruin your name, and salt your fields."),

	OUTLANDER_1			(Backgrounds.OUTLANDER.getBackgroundId(), 	"I'm driven by a wanderlust that led me away from home."),
	OUTLANDER_2			(Backgrounds.OUTLANDER.getBackgroundId(), 	"I watch over my friends as if they were a litter of newborn pups."),
	OUTLANDER_3			(Backgrounds.OUTLANDER.getBackgroundId(), 	"I once ran twenty-five miles without stopping to warn my clan of an approaching orc horde. I'd do it again if I had to."),
	OUTLANDER_4			(Backgrounds.OUTLANDER.getBackgroundId(), 	"I have a lesson for every situation, drawn from observing nature."),
	OUTLANDER_5			(Backgrounds.OUTLANDER.getBackgroundId(), 	"I place no stock in wealthy or well-mannered folk. Money and manners won't save you from a hungry owlbear."),
	OUTLANDER_6			(Backgrounds.OUTLANDER.getBackgroundId(), 	"I'm always picking things up, absently fiddling with them, and sometimes accidentally breaking them."),
	OUTLANDER_7			(Backgrounds.OUTLANDER.getBackgroundId(), 	"I feel far more comfortable around animals than people."),
	OUTLANDER_8			(Backgrounds.OUTLANDER.getBackgroundId(), 	"I was, in fact, raised by wolves."),

	SAGE_1				(Backgrounds.SAGE.getBackgroundId(), 	"I use polysyllabic words to convey the impression of great erudition."),
	SAGE_2				(Backgrounds.SAGE.getBackgroundId(), 	"I've read every book in the world's greatest libraries--or like to boast that I have."),
	SAGE_3				(Backgrounds.SAGE.getBackgroundId(), 	"I'm used to helping out those who aren't as smart as I am, and I patiently explain anything and everything to others."),
	SAGE_4				(Backgrounds.SAGE.getBackgroundId(), 	"There's nothing I like more than a good mystery."),
	SAGE_5				(Backgrounds.SAGE.getBackgroundId(), 	"I'm willing to listen to every side of an argument before I make my own judgment."),
	SAGE_6				(Backgrounds.SAGE.getBackgroundId(), 	"I...speak...slowly...when talking...to idiots...which...almost...everyone...is...compared ...to me."),
	SAGE_7				(Backgrounds.SAGE.getBackgroundId(), 	"I am horribly, horribly awkward in social situations."),
	SAGE_8				(Backgrounds.SAGE.getBackgroundId(), 	"I'm convinced that people are always trying to steal my secrets."),

	SAILOR_1			(Backgrounds.SAILOR.getBackgroundId(), 	"My friends know they can rely on me, no matter what."),
	SAILOR_2			(Backgrounds.SAILOR.getBackgroundId(), 	"I work hard so that I can play hard when the work is done."),
	SAILOR_3			(Backgrounds.SAILOR.getBackgroundId(), 	"I enjoy sailing into new ports and making new friends over a flagon of ale."),
	SAILOR_4			(Backgrounds.SAILOR.getBackgroundId(), 	"I stretch the truth for the sake of a good story."),
	SAILOR_5			(Backgrounds.SAILOR.getBackgroundId(), 	"To me, a tavern brawl is a nice way to get to know a new city."),
	SAILOR_6			(Backgrounds.SAILOR.getBackgroundId(), 	"I never pass up a friendly wager."),
	SAILOR_7			(Backgrounds.SAILOR.getBackgroundId(), 	"My language is as foul as an otyugh nest."),
	SAILOR_8			(Backgrounds.SAILOR.getBackgroundId(), 	"I like a job well done, especially if I can convince someone else to do it."),

	SOLDIER_1			(Backgrounds.SOLDIER.getBackgroundId(), 	"I'm always polite and respectful."),
	SOLDIER_2			(Backgrounds.SOLDIER.getBackgroundId(), 	"I'm haunted by memories of war. I can't get the images of violence out of my mind."),
	SOLDIER_3			(Backgrounds.SOLDIER.getBackgroundId(), 	"I've lost too many friends, and I'm slow to make new ones."),
	SOLDIER_4			(Backgrounds.SOLDIER.getBackgroundId(), 	"I'm full of inspiring and cautionary tales from my military experience relevant to almost every combat situation."),
	SOLDIER_5			(Backgrounds.SOLDIER.getBackgroundId(), 	"I can stare down a hellhound without flinching."),
	SOLDIER_6			(Backgrounds.SOLDIER.getBackgroundId(), 	"I enjoy being strong and like breaking things."),
	SOLDIER_7			(Backgrounds.SOLDIER.getBackgroundId(), 	"I have a crude sense of humor."),
	SOLDIER_8			(Backgrounds.SOLDIER.getBackgroundId(), 	"I face problems head-on. A simple direct solution is the best path to success."),

	URCHIN_1			(Backgrounds.URCHIN.getBackgroundId(), 	"I hide scraps of food and trinkets away in my pockets."),
	URCHIN_2			(Backgrounds.URCHIN.getBackgroundId(), 	"I ask a lot of questions."),
	URCHIN_3			(Backgrounds.URCHIN.getBackgroundId(), 	"I like to squeeze into small places where no one else can get to me."),
	URCHIN_4			(Backgrounds.URCHIN.getBackgroundId(), 	"I sleep with my back to a wall or tree, with everything I own wrapped in a bundle in my arms."),
	URCHIN_5			(Backgrounds.URCHIN.getBackgroundId(), 	"I eat like a pig and have bad manners."),
	URCHIN_6			(Backgrounds.URCHIN.getBackgroundId(), 	"I think anyone who's nice to me is hiding evil intent."),
	URCHIN_7			(Backgrounds.URCHIN.getBackgroundId(), 	"I don't like to bathe."),
	URCHIN_8			(Backgrounds.URCHIN.getBackgroundId(), 	"I bluntly say what other people are hinting or hiding.");

	//@formatter:on

	private final Integer backgroundId;
	private final String personalityTraitText;

	PersonalityTraits(Integer backgroundId, String personalityTraitText) {
		this.backgroundId = backgroundId;
		this.personalityTraitText = personalityTraitText;
	}

	public Integer getBackgroundId() {
		return backgroundId;
	}

	public String getPersonalityTraitText() {
		return personalityTraitText;
	}

	public static PersonalityTraits[] getPersonalityTraits() {
		return PersonalityTraits.values();
	}

	@Override
	public String toString() {
		return this.personalityTraitText;
	}

}
