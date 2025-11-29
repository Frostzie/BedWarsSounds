package io.github.frostzie.bedwars_sounds.config

enum class KillMessageTemplate(
    val normalKill: String,
    val voidKill: String,
    val bowKill: String,
    val groundKill: String,
    val golemKill: String,
    val customKill: String? = null
) {
    DEFAULT(
        normalKill = "was killed by PLAYER.",
        voidKill = "was knocked into the void by PLAYER.",
        bowKill = "was killed by PLAYER.",
        groundKill = "was knocked off a cliff by PLAYER.",
        golemKill = "was killed by PLAYER's Dream Defender.",
    ),

    FIRE(
        normalKill = "was struck down by PLAYER.",
        voidKill = "was turned to dust by PLAYER.",
        bowKill = "was melted by PLAYER.",
        groundKill = "was turned to ash by PLAYER.",
        golemKill = "was fried by PLAYER's Golem.",
    ),

    WESTERN(
        normalKill = "was filled full of lead by PLAYER.",
        voidKill = "met their end by PLAYER.",
        bowKill = "was killed with dynamite by PLAYER.",
        groundKill = "lost a drinking contest with PLAYER.",
        golemKill = "lost the draw to PLAYER's Golem.",
    ),

    HONOURABLE(
        normalKill = "died in close combat to PLAYER.",
        voidKill = "fought to the edge with PLAYER.",
        bowKill = "fell to the great marksmanship of PLAYER.",
        groundKill = "stumbled off a ledge with help by PLAYER.",
        golemKill = "tangoed with PLAYER's Golem.",
    ),

    MULTIVERSE(
        normalKill = "was distorted by PLAYER.",
        voidKill = "was thrown into the singularity by PLAYER.",
        bowKill = "was shot into another dimension by PLAYER.",
        groundKill = "was thrown into a black hole by PLAYER.",
        golemKill = "was launched into a wormhole by PLAYER's Golem.",
    ),

    LIMBO(
        normalKill = "was sent to limbo by PLAYER.",
        voidKill = "was pushed into limbo by PLAYER.",
        bowKill = "was shot into limbo by PLAYER.",
        groundKill = "was pushed into limbo by PLAYER.",
        golemKill = "was launched into limbo by PLAYER's Golem.",
    ),

    LOVE(
        normalKill = "was given the cold shoulder by PLAYER.",
        voidKill = "was hit off by a love bomb from PLAYER.",
        bowKill = "was struck with Cupid's arrow by PLAYER.",
        groundKill = "was out of the league of PLAYER.",
        golemKill = "was no match for PLAYER's Golem.",
    ),

    BBQ(
        normalKill = "was glazed in BBQ sauce by PLAYER.",
        voidKill = "slipped in BBQ sauce off the edge spilled by PLAYER.",
        bowKill = "was thrown chili powder at by PLAYER.",
        groundKill = "was not spicy enough for PLAYER.",
        golemKill = "was sliced up by PLAYER's Golem.",
    ),

    WOOF_WOOF(
        normalKill = "was bitten by PLAYER.",
        voidKill = "howled into the void for PLAYER.",
        bowKill = "caught the ball thrown by PLAYER.",
        groundKill = "was distracted by a puppy placed by PLAYER.",
        golemKill = "played too rough with PLAYER's Golem.",
    ),

    SANTAS_WORKSHOP(
        normalKill = "was wrapped into a gift by PLAYER.",
        voidKill = "hit the hard-wood floor because of PLAYER.",
        bowKill = "was put on the naughty list by PLAYER.",
        groundKill = "was pushed down a slope by PLAYER.",
        golemKill = "was turned to gingerbread by PLAYER's Golem.",
    ),

    PRIMAL(
        normalKill = "was hunted down by PLAYER.",
        voidKill = "stumbled on a trap set by PLAYER.",
        bowKill = "got skewered by PLAYER.",
        groundKill = "was thrown into a volcano by PLAYER.",
        golemKill = "was mauled by PLAYER's Golem.",
    ),

    OINK(
        normalKill = "was oinked by PLAYER.",
        voidKill = "slipped into void for PLAYER.",
        bowKill = "got attacked by a carrot from PLAYER.",
        groundKill = "was distracted by a piglet from PLAYER.",
        golemKill = "was oinked by PLAYER's Golem.",
    ),

    SQUEAK(
        normalKill = "was chewed up by PLAYER.",
        voidKill = "was scared into the void by PLAYER.",
        bowKill = "stepped in a mouse trap placed by PLAYER.",
        groundKill = "was distracted by a rat dragging pizza from PLAYER.",
        golemKill = "squeaked around with PLAYER's Golem.",
    ),

    BUZZ(
        normalKill = "was buzzed to death by PLAYER.",
        voidKill = "was bzzz'd into the void by PLAYER.",
        bowKill = "was startled by PLAYER.",
        groundKill = "was stung off the edge by PLAYER.",
        golemKill = "was bee'd by PLAYER's Golem.",
    ),

    OXD(
        normalKill = "was trampled by PLAYER.",
        voidKill = "was back kicked into the void by PLAYER.",
        bowKill = "was impaled from a distance by PLAYER.",
        groundKill = "was headbutted off a cliff by PLAYER.",
        golemKill = "was trampled by PLAYER's Golem.",
    ),

    PIRATE(
        normalKill = "be sent to Davy Jones' locker by PLAYER.",
        voidKill = "be cannonballed to death by PLAYER.",
        bowKill = "be shot and killed by PLAYER.",
        groundKill = "be killed with magic by PLAYER.",
        golemKill = "be killed with metal by PLAYER's Golem.",
    ),

    LITERALLY_SPOOKY(
        normalKill = "was spooked by PLAYER.",
        voidKill = "was spooked off the map by PLAYER.",
        bowKill = "was remotely spooked by PLAYER.",
        groundKill = "was totally spooked by PLAYER.",
        golemKill = "was spooked by PLAYER's Golem.",
    ),

    MEMED(
        normalKill = "got rekt by PLAYER.",
        voidKill = "took the L to PLAYER.",
        bowKill = "got smacked by PLAYER.",
        groundKill = "got roasted by PLAYER.",
        golemKill = "got bamboozled by PLAYER's Golem.",
    ),

    DRAMATIC(
        normalKill = "was tragically backstabbed by PLAYER.",
        voidKill = "was heartlessly let go by PLAYER.",
        bowKill = "Player's heart was pierced by PLAYER.",
        groundKill = "was delivered into nothingness by PLAYER.",
        golemKill = "was dismembered by PLAYER's Golem.",
    ),

    NOBLE(
        normalKill = "was crushed by PLAYER.",
        voidKill = "was dominated by PLAYER.",
        bowKill = "was assassinated by PLAYER.",
        groundKill = "was thrown off their high horse by PLAYER.",
        golemKill = "was degraded by PLAYER's Golem.",
        customKill = "was PLAYER's final #"
    ),

    SNOW_STORM(
        normalKill = "was locked outside during a snow storm by PLAYER.",
        voidKill = "was pushed into a snowbank by PLAYER.",
        bowKill = "was hit with a snowball from PLAYER.",
        groundKill = "was shoved down an icy slope by PLAYER.",
        golemKill = "got snowed in by PLAYER's Golem.",
    ),

    EGGY(
        normalKill = "was painted pretty by PLAYER.",
        voidKill = "was deviled into the void by PLAYER.",
        bowKill = "slipped into a pan placed by PLAYER.",
        groundKill = "was flipped off the edge by PLAYER.",
        golemKill = "was made sunny side up by PLAYER's Golem.",
    ),

    CELEBRATORY(
        normalKill = "was whacked with a party balloon by PLAYER.",
        voidKill = "was popped into the void by PLAYER.",
        bowKill = "was shot with a roman candle by PLAYER.",
        groundKill = "was launched like a firework by PLAYER.",
        golemKill = "was lit up by PLAYER's Golem.",
    ),

    WRAPPED_UP(
        normalKill = "was wrapped up by PLAYER.",
        voidKill = "was tied into a bow by PLAYER.",
        bowKill = "was glued up by PLAYER.",
        groundKill = "tripped over a present placed by PLAYER.",
        golemKill = "was taped together by PLAYER's Golem.",
    ),

    TO_THE_MOON(
        normalKill = "was crushed into moon dust by PLAYER.",
        voidKill = "was sent the wrong way by PLAYER.",
        bowKill = "was hit by an asteroid from PLAYER.",
        groundKill = "was blasted to the moon by PLAYER.",
        golemKill = "was blown up by PLAYER's Golem.",
    ),

    FESTIVE(
        normalKill = "was smothered in holiday cheer by PLAYER.",
        voidKill = "was banished into the ether by PLAYER's holiday spirit.",
        bowKill = "was sniped by a missile of festivity by PLAYER.",
        groundKill = "was pushed by PLAYER's holiday spirit.",
        golemKill = "was sung holiday tunes to by PLAYER's Golem.",
    ),

    ROAR(
        normalKill = "was ripped to shreds by PLAYER.",
        voidKill = "was charged by PLAYER.",
        bowKill = "was pounced on by PLAYER.",
        groundKill = "was ripped and thrown by PLAYER.",
        golemKill = "was ripped to shreds by PLAYER's Golem.",
    ),

    TRIUMPH(
        normalKill = "was bested by PLAYER.",
        voidKill = "was knocked into the void by PLAYER.",
        bowKill = "was shot by PLAYER.",
        groundKill = "was knocked off an edge by PLAYER.",
        golemKill = "was bested by PLAYER's Golem.",
        customKill = "was PLAYER's final #"
    ),

    GLORIOUS(
        normalKill = "was stomped by PLAYER.",
        voidKill = "was thrown down a pit by PLAYER.",
        bowKill = "was shot by PLAYER.",
        groundKill = "was thrown to the ground by PLAYER.",
        golemKill = "was outclassed by PLAYER's Golem.",
        customKill = "was PLAYER's final #"
    ),

    BRIDGING_FOR_DUMMIES(
        normalKill = "had a small brain moment while fighting PLAYER.",
        voidKill = "was not able to block clutch against PLAYER.",
        bowKill = "got 360 no-scoped by PLAYER.",
        groundKill = "forgot how many blocks they had left while fighting PLAYER.",
        golemKill = "got absolutely destroyed by PLAYER's Golem.",
    ),

    SOCIAL_DISTANCE(
        normalKill = "was too shy to meet PLAYER.",
        voidKill = "didn't distance themselves properly from PLAYER.",
        bowKill = "was coughed at by PLAYER.",
        groundKill = "tripped while trying to run away from PLAYER.",
        golemKill = "got too close to PLAYER's Golem.",
    ),

    OLD_MAN(
        normalKill = "was yelled at by PLAYER.",
        voidKill = "was thrown off the lawn by PLAYER.",
        bowKill = "was accidentally spit on by PLAYER.",
        groundKill = "slipped on the fake teeth of PLAYER.",
        golemKill = "was chased away by PLAYER's Golem.",
    );

    companion object {
        /**
         * Returns all unique kill messages across all templates
         */
        fun getAllMessages(): List<String> {
            val messages = mutableSetOf<String>()
            entries.forEach { template ->
                messages.add(template.normalKill)
                messages.add(template.voidKill)
                messages.add(template.bowKill)
                messages.add(template.groundKill)
                messages.add(template.golemKill)
                template.customKill?.let { messages.add(it) }
            }
            return messages.toList()
        }

        /**
         * Finds which kill type a message belongs to
         */
        fun getKillType(message: String): String? {
            entries.forEach { template ->
                when (message) {
                    template.normalKill -> return "NormalKill"
                    template.voidKill -> return "VoidKill"
                    template.bowKill -> return "BowKill"
                    template.groundKill -> return "GroundKill"
                    template.golemKill -> return "GolemKill"
                    template.customKill -> return "CustomKill"
                }
            }
            return null
        }
    }
}