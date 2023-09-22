import {
	solutions,
	testCases,
} from "@/StriverA2ZDSASheet/Step3-Arrays/medium/SpiralMatrix";
import { expect, test } from "bun:test";

solutions.forEach(s => {
	testCases.forEach(([t, right]) => {
		test(`${import.meta.file} ${s.name} ${JSON.stringify(t)}`, () => {
			expect(s(t)).toEqual(right);
		});
	});
});
