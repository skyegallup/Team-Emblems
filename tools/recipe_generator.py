color_names = ["black", "blue", "brown", "cyan", "gray", "green", "light_blue", "light_gray", "lime", "magenta", "orange", "pink", "purple", "red", "white", "yellow"]
for color_name in color_names:
    json = """{{
    "type": "minecraft:crafting_shaped",
    "category": "equipment",
    "group": "team_emblems:emblems",
    "show_notification": true,
    "pattern": [
        " C ",
        "CWC",
        " C "
    ],
    "key": {{
        "C": {{
            "item": "minecraft:copper_ingot"
        }},
        "W": {{
            "item": "minecraft:{0}_wool"
        }}
    }},
    "result": {{
        "item": "team_emblems:{0}_emblem"
    }}
}}""".format(color_name)
    with open("{}_emblem.json".format(color_name), "w") as f:
        f.write(json)
